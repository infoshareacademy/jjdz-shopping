package com.speed.service;

import com.speed.model.Category;
import com.speed.model.SearchEvent;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.stream.XMLStreamException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by damian on 22.04.16.
 */
@Stateless
public class CategorySearch {
    final static Logger logger = Logger.getLogger(CategorySearch.class);
    private static final String ALLEGRO_XML = "files/allegro.xml";
    @EJB
    ClientReport clientReport;

    @PersistenceContext
    EntityManager em;
    private List<Category> parsedCategories;

    public CategorySearch() throws XMLStreamException {
        this.parsedCategories = new CategoryParserManager().parseAndPersist(ALLEGRO_XML);
    }

    public List<Category> getParsedCategories() {
        return parsedCategories;
    }

    public void setParsedCategories(List<Category> parsedCategories) {
        this.parsedCategories = parsedCategories;
    }


    public List<Category> searchCategoryByGivenProduct(String searchedProduct) {


        List<Category> foundCategories = new ArrayList<>();
        SearchEvent searchEvent = new SearchEvent();

        searchEvent.setProduct(searchedProduct);
        searchEvent.setDate(LocalDate.now());
        clientReport.sendEvent(searchEvent);

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
            Category currentCategory = findCategoryById(catId);
            currentPath = currentCategory.getCatName();
            builder.insert(0, " >> ");
            builder.insert(0, currentPath);
            catId = currentCategory.getCatParent();
        } while (catId != 0);

        return  builder;
    }
}

