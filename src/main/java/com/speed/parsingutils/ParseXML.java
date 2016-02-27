package com.speed.parsingutils;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotr on 13.02.16.
 */
public class ParseXML {

    public static void main(String[] args) throws XMLStreamException {

        Allegro allegro = null;
        List<Allegro> allegroList = null;
        String tagContent = null;
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader parsner = factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream("files/allegro1.xml"));

        while (parsner.hasNext()) {

            int event = parsner.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if ("id".equals(parsner.getLocalName())) {
                        allegro = new Allegro();
                        allegro.id = parsner.getAttributeValue(0);
                    }

                    if ("allegroList".equals(parsner.getLocalName())) {
                        allegroList = new ArrayList<Allegro>();
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    tagContent = parsner.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    String s = parsner.getLocalName();
                    if (s.equals("employee")) {
                        allegroList.add(allegro);

                    } else if (s.equals("catName")) {
                        allegro.catName = tagContent;
                        break;

                    } else if (s.equals("catParent")) {
                        allegro.catParent = tagContent;
                        break;

                    } else if (s.equals("catPosition")) {
                        allegro.catPosition = tagContent;
                        break;

                    }
                    break;

                case XMLStreamConstants.START_DOCUMENT:
                    allegroList = new ArrayList<Allegro>();
                    break;
            }

        }
        for (Allegro alg : allegroList) {
            System.out.println("alg");
        }
    }
}

class Allegro {
    String id;
    String catName;
    String catParent;
    String catPosition;


    @Override
    public String toString() {
        return "Allegro{" +
                "catId='" + id + '\'' +
                ", catName='" + catName + '\'' +
                ", catParent='" + catParent + '\'' +
                ", catPosition='" + catPosition + '\'' +
                '}';
    }
}


