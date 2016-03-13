package com.speed.service;

import com.speed.model.Product;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

/**
 * Created by ewa on 3/6/16.
 */
public class ReadXMLFile {

    public Product parseXML(String xmlStr, Product product) throws IOException, ParserConfigurationException, SAXException, NullPointerException {

        try (PrintWriter pw = new PrintWriter("XML.xml", "UTF-8")) {
            pw.println(xmlStr);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw e;
        }

        File file = new File("XML.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(file);

        if (doc != null) {
            doc.getDocumentElement().normalize();
            Element dataElement = (Element) doc.getElementsByTagName("Data").item(0);


            try {
                Element ownerElement = (Element) dataElement.getElementsByTagName("a:Owner").item(0);
                Element productElement = (Element) dataElement.getElementsByTagName("a:Product").item(0);

                String productName = productElement.getElementsByTagName("b:Name").item(0).getTextContent();
                String ownerName = ownerElement.getElementsByTagName("b:Name").item(1).getTextContent();

                if (ownerName == null) {
                    product.setManufacturerName("No information about manufacturer");
                } else {
                    product.setManufacturerName(ownerName);
                }

                if (productName == null) {
                    product.setManufacturerName("No information about product name");
                } else {
                    product.setProductName(productName);
                }
            } catch (NullPointerException e) {
                throw e;
            }
        }

        return product;
    }
}