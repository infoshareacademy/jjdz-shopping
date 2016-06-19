package com.speed.SearchByBarcode;

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

    private static final String MSG_NO_MANUF = "No information about manufacturer";
    private static final String MSG_NO_NAME = "No information about product name";

    public ProductFromBarcode parseXML(String xmlStr, ProductFromBarcode product) throws IOException, ParserConfigurationException, SAXException, NullPointerException {

        printXmlContent(xmlStr);

        Document doc = getFileHandler();

        if (doc != null) {
            doc.getDocumentElement().normalize();
            Element dataElement = (Element) doc.getElementsByTagName("Data").item(0);


            try {
                Element ownerElement = (Element) dataElement.getElementsByTagName("a:Owner").item(0);
                Element productElement = (Element) dataElement.getElementsByTagName("a:Product").item(0);

                String productName = productElement.getElementsByTagName("b:Name").item(0).getTextContent();
                String ownerName = ownerElement.getElementsByTagName("b:Name").item(1).getTextContent();

                if (ownerName == null) {
                    product.setManufacturerName(MSG_NO_MANUF);
                } else {
                    product.setManufacturerName(ownerName);
                }

                if (productName == null) {
                    product.setManufacturerName(MSG_NO_NAME);
                } else {
                    product.setProductName(productName);
                }
            } catch (NullPointerException e) {
                throw e;
            }
        }

        return product;
    }

    private Document getFileHandler() throws ParserConfigurationException, SAXException, IOException {
        File file = new File("XML.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        return dBuilder.parse(file);
    }

    private void printXmlContent(String xmlStr) throws FileNotFoundException, UnsupportedEncodingException {
        try (PrintWriter pw = new PrintWriter("XML.xml", "UTF-8")) {
            pw.println(xmlStr);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw e;
        }
    }
}
