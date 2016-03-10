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
import javax.xml.transform.stream.StreamSource;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

/**
 * Created by ewa on 2/21/16.
 */
public class ProductApp {

    public Product getProduct() throws ParserConfigurationException, SAXException {

        //decode picture to code

        String fileName = getFilePath();
        BinaryBitmap myMap = GetBitMapfromFile(fileName);
        MultiFormatReader reader = new MultiFormatReader();
        Result result = null;
        try {
            result = reader.decode(myMap);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        if (result == null) {
            throw new AssertionError();
        }

        Product product = new Product();

        String gtin = result.getText();  //toString????
//        String gtin = "05900352000602";
        product.setProductNumber(gtin);

        //druga czesc - wyciagniecie info z API
        RestAPIProvider r = new RestAPIProvider("http://api3.produktywsieci.pl/PublicService.svc/rest/xml/GetProductByGTIN");
        String APIkey = "bd9HdzJMoMvpkn@JuVfp@Czozrpc_UM4gvmn";

        r.addParam("gs1Key", APIkey);
        r.addParam("gtin", gtin);

        String stringWithRestResponse = null;
        try {
            stringWithRestResponse = r.sendRestApiRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReadXMLFile rxm = new ReadXMLFile();

        try {
            product = rxm.parseXML(stringWithRestResponse, product);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return product;
    }

    private BinaryBitmap GetBitMapfromFile(String fileName) {
        File img = new File(fileName);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(img);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (bufferedImage == null) {
            throw new AssertionError();
        }
        HybridBinarizer hb = new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage));

        return new BinaryBitmap(hb);
    }


    public String getFilePath() {
        return "/home/ewa/Documents/Programming/IdeaProjects/jjdz-shopping/src/main/java/com/speed/service/IMG_0528.JPG";
    }
}

