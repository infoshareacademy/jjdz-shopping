package com.speed.service;

import com.speed.model.Category;
import com.speed.parsingutils.ParseXML;

import javax.ejb.Stateless;
import javax.xml.stream.XMLStreamException;
import java.util.*;

/**
 * Created by damian on 22.04.16.
 */
@Stateless
public class CategorySearch {

    private List<Category> parsedCategories;

    public CategorySearch() throws XMLStreamException {
        this.parsedCategories = new ParseXML().parsStax("files/allegro.xml");

    }

    public List<Category> getParsedCategories() {
        return parsedCategories;
    }

    public List<Category> searchCategoryByGivenProduct(String searchedProduct) {

        List<Category> foundCategories = new ArrayList<>();

        for (Category cat : parsedCategories) {
            if (cat.getCatName().toLowerCase().contains(searchedProduct.toLowerCase())) {
                foundCategories.add(cat);
            }
        }

        return foundCategories;
    }

    public List<Category> findCategoryChildren(int catId){

        List<Category> subcategories = new ArrayList<>();

        for (Category cat : parsedCategories) {
            if (cat.getCatParent() == catId){
                subcategories.add(cat);
            }
        }

        return subcategories;
    }

    public Category findCategoryById(int catId){

        Category category = null;

        for (Category cat : parsedCategories){
            if (cat.getCatId() == catId){
                category = cat;
            }
        }

        return  category;
    }

    public StringBuilder showPath(int catId){

        String currentPath = "";
        StringBuilder builder = new StringBuilder();

        do {
            int currentCatId = findCategoryById(catId).getCatId();
            currentPath = findCategoryById(currentCatId).getCatName();
            builder.insert(0, " >> ");
            builder.insert(0, currentPath);
            catId = findCategoryById(currentCatId).getCatParent();
        } while (catId != 0);

        return  builder;
    }
}

