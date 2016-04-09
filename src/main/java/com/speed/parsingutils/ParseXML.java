package com.speed.parsingutils;

import com.speed.model.Category;

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


    }


    public void parsStax() throws XMLStreamException {


        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader parser = factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream("files/allegro.xml"));


        List<Category> categoryList = null;
        Category category = null;
        String text = null;
        boolean inItem = false;
        String currentTag = null;

        while (parser.hasNext()) {
            int event = parser.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    String tagName = parser.getLocalName();
                    if (tagName.equals("item")) {
                        inItem = true;

                        categoryList = new ArrayList<>();
                        category = new Category();


                    }
                    if (inItem) {
                        currentTag = tagName;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    if (inItem) {
                        text = parser.getText().trim();
                        break;
//

                    }

                case XMLStreamConstants.END_ELEMENT:
                    if (!text.isEmpty()) {
                        if (parser.getLocalName().equals("item")) {
                            switch (currentTag) {
                                case "item":
                                    categoryList.add(category);
                                    break;
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

                            }
                            inItem = false;
                        }
                        break;
                    }

                case XMLStreamConstants.ATTRIBUTE:
                    break;


            }
        }
    }

    }



