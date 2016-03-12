package com.speed.parsingutils;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.StartElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by piotr on 13.02.16.
 */
public class ParseXML {

    public static void main(String[] args) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader parser = factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream("files/allegro.xml"));

        boolean inItem = false;
        String currentTag = "";

        while (parser.hasNext()) {
            int event = parser.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    String tagName = parser.getLocalName();
                    if (tagName.equals("item")) {
                        inItem = true;
                        int attrCount = parser.getAttributeCount();
                        System.out.println(attrCount);
                        //zaczynamy zbierac
                    }
                    if (inItem) {
                        currentTag = tagName;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    if (inItem) {
                        String text = parser.getText().trim();
                        if (!text.isEmpty()) {
                            System.out.println(currentTag + " - " + text);
                            //zbieramy
                        }

                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (parser.getLocalName().equals("item")) {
                        //zebrane uzywamy do stworzenia kategorii
                        inItem = false;
                    }
                    break;
                case XMLStreamConstants.ATTRIBUTE:

                    break;

            }
        }

    }
}
