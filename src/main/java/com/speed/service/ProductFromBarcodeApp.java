package com.speed.service;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.speed.model.Category;
import com.speed.model.ProductFromBarcode;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by ewa on 2/21/16.
 */


@Stateless
public class ProductFromBarcodeApp {

    @Inject
    CategorySearch categorySearch;

    final static Logger logger = Logger.getLogger(ProductFromBarcodeApp.class);


    public ProductFromBarcode findProduct(BinaryBitmap myMap) throws IOException, XMLStreamException {

        //decode picture to number
        Result result;
        try {
            MultiFormatReader reader = new MultiFormatReader();
            result = reader.decode(myMap);
        }catch (NotFoundException e) {
            e.printStackTrace();
            throw new IOException("Error during reading and parsing from file. Reason: " + e.getMessage(), e);
        }

        ProductFromBarcode product = new ProductFromBarcode();
        String gtin = result.getText();
        product.setProductNumber(gtin);

        //part 2 - REST API request
        RestAPIProvider r = new RestAPIProvider("http://api3.produktywsieci.pl/PublicService.svc/rest/xml/GetProductByGTIN");
        String APIkey = "bd9HdzJMoMvpkn@JuVfp@Czozrpc_UM4gvmn";

        r.addParam("gs1Key", APIkey);
        r.addParam("gtin", gtin);

        try {
            String stringWithRestResponse = r.sendRestApiRequest();
            ReadXMLFile rxm = new ReadXMLFile();
            product = rxm.parseXML(stringWithRestResponse, product);
        } catch (IOException | SAXException | ParserConfigurationException | NullPointerException e) {
            throw new IOException("Error during getting product information. Reason: "+ e.getMessage(),e);
        }

        // part 3 - findig allegro categories for product

//        List<Category> categories = FindKeyWord(product.getProductName());
//        product.setProductCategories(categories);
        FindKeyWord(product);

        return product;

    }

    public BinaryBitmap GetBitMap(InputStream stream) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(stream);

        if (bufferedImage == null) {
            throw new AssertionError();
        }
        HybridBinarizer hb = new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage));

        return new BinaryBitmap(hb);
    }

    public BinaryBitmap GetBitMap(String fileName) throws IOException {
        File img = new File(fileName);
        BufferedImage bufferedImage;
        bufferedImage = ImageIO.read(img);

        if (bufferedImage == null) {
            throw new AssertionError();
        }
        HybridBinarizer hb = new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage));

        return new BinaryBitmap(hb);
    }

    public ProductFromBarcode FindKeyWord(ProductFromBarcode product) throws XMLStreamException {

        String productName = product.getProductName();

        Pattern pattern = Pattern.compile("[^a-zA-Z]+");
        String[] result = pattern.split(productName);

        for (String i:result) {
            List<Category> catList = categorySearch.searchCategoryByGivenProduct(i.toLowerCase());
            if (!catList.isEmpty()) {
                product.setProductCategories(catList);
                product.setProductKeyWord(i);
                return product;
            }
        }
        return null;
    }


//    public String getFilePath() {
//        return "/home/ewaw/Workspace/jjdz-shopping/src/main/resources/files/barcode.png";
//    }
}

