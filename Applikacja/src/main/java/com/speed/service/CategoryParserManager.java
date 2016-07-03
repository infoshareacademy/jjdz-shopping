package com.speed.service;

import com.speed.model.Category;
import com.speed.parsingutils.ParseXML;

import javax.xml.stream.XMLStreamException;
import java.util.List;


public class CategoryParserManager {
//
//    @EJB
//    ParseXML parser;
//
//    @EJB
//    private CategoriesDB categoriesDB;


    public CategoryParserManager() {
    }

    public List<Category> parseAndPersist(String fileName) throws XMLStreamException {
        List<Category> parsedCategories = new ParseXML().parsStax(fileName);
//        new CategoriesDB().saveToDbParsedCategories(parsedCategories);

        return parsedCategories;
//    return new ArrayList<>();
    }



}
