package com.speed.parsingutils;

import com.speed.model.Category;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * Created by piotr
 */

public class ParseXML {


    final  static Logger loger = Logger.getLogger(ParseXML.class);

//    public static void main(String[] args) {
//        ParseXML xml = new ParseXML();
//        try {
//          List<Category> categories = xml.parsStax("files/allegro.xml");
//            System.out.println(categories);
//        } catch (XMLStreamException e) {
//            e.printStackTrace();
//        }
//
//
//    }

    public List<Category> parsStax(final String fileName) throws XMLStreamException {

        if (fileName == null || fileName.trim().equals("")) {
            return Collections.emptyList();
        }

        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader parser = factory
                .createXMLStreamReader(getClass().getClassLoader().getResourceAsStream(fileName));


        List<Category> categoryList = new ArrayList<>();
        Category category = null;
        String text = null;
        boolean inItem = false;


        while (parser.hasNext()) {
            int event = parser.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    String tagName = parser.getLocalName();
                    if (tagName.equals("item")) {
                        category = new Category();
                        inItem = true;
                    }

                    break;

                case XMLStreamConstants.CHARACTERS:
                    if (inItem) {
                        text = parser.getText().trim();

                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (parser.getLocalName()) {
                        case "item":
                            categoryList.add(category);
                            break;
                        case "catId":
                            category.setCatId(Integer.valueOf(text));
                            break;
                        case "catName":
                            category.setCatName(text);
                            break;
                        case "catParent":
                            category.setCatParent(Integer.valueOf(text));
                            break;
                        case "catPosition":
                            category.setCatPosition(Integer.valueOf(text));
                            break;
                        case "catIsProductCatalogueEnabled":
                            category.setCatIsProductCatalogueEnabled(Integer.valueOf(text));
                            break;
                    }
                    break;

                case XMLStreamConstants.START_DOCUMENT:
                    categoryList = new ArrayList<>();
                    break;
            }
        }

        return categoryList;
    }

}