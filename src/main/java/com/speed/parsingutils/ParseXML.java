package com.speed.parsingutils;

import com.google.zxing.common.StringUtils;
import com.speed.model.Category;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


/**
 * Created by piotr on 13.02.16.
 */
public class ParseXML {


    public List<Category> parsStax(final String fileName) {

        if (fileName == null || fileName.trim().equals("")){
            return Collections.emptyList();
        }

        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader parser = null;
        try {
            parser = factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream(fileName));
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        List<Category> categoryList = new ArrayList<>();
        Category category;
        String text = null;
        boolean inItem;
        String currentTag = null;

        try {
            while (parser.hasNext()) {
                int event = parser.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        String tagName = parser.getLocalName();
                        if (tagName.equals("item")) {
                            inItem = true;

//                            categoryList = new ArrayList<>();
                             category = new Category();

                            while (parser.hasNext()) {
                                int innerEvent = parser.next();
                                switch (innerEvent) {

                                    case XMLStreamConstants.CHARACTERS:
                                        if (inItem) {
                                            text = parser.getText().trim();
                                            break;
                                        }

                                    case XMLStreamConstants.END_ELEMENT:
                                        if (!text.isEmpty()) {
                                            if (parser.getLocalName().equals("item")) {
                                                switch (currentTag) {
                                                    case "catId":
                                                        category.setCatParent(Integer.valueOf(text));
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
                                                    case "item":
                                                        categoryList.add(category);
                                                        break;
                                                }
                                                inItem = false;

                                                break;
                                            }
                                        }

                                    case XMLStreamConstants.ATTRIBUTE:
                                        break;
                                }
                            }
                            if (inItem) {
                                currentTag = tagName;
                            }

                        }
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();

        }
        return categoryList;
    }
}