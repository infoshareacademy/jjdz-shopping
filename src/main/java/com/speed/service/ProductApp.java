package com.speed.service;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.speed.model.Product;
import org.xml.sax.SAXException;

import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by ewa on 2/21/16.
 */
public class ProductApp {

    public Product findProduct(String fileName) throws IOException {

        //decode picture to number
        Result result;
        try {
            BinaryBitmap myMap = GetBitMapfromFile(fileName);
            MultiFormatReader reader = new MultiFormatReader();
            result = reader.decode(myMap);
        }catch (IOException  | NotFoundException e) {
            e.printStackTrace();
            throw new IOException("Error during reading and parsing from file. Reason: " + e.getMessage(), e);
        }

        Product product = new Product();
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

        return product;

    }

    private BinaryBitmap GetBitMapfromFile(String fileName) throws IOException {
        File img = new File(fileName);
        BufferedImage bufferedImage;
        bufferedImage = ImageIO.read(img);

        if (bufferedImage == null) {
            throw new AssertionError();
        }
        HybridBinarizer hb = new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage));

        return new BinaryBitmap(hb);
    }


//    public String getFilePath() {
//        return "/home/ewaw/Workspace/jjdz-shopping/src/main/resources/files/barcode.png";
//    }
}

