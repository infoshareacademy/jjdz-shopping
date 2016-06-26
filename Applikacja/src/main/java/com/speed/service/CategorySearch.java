package com.speed.service;

import com.speed.model.Category;
import com.speed.kosz.ReportPopularProducts;
import com.speed.kosz.PopularProductRepo;
import com.speed.model.SearchEvent;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.stream.XMLStreamException;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by damian on 22.04.16.
 */
@Stateless
public class CategorySearch {

//    @EJB
//    PopularProductRepo popularProductRepo;

    final static Logger logger = Logger.getLogger(CategorySearch.class);

    private List<Category> parsedCategories;

    @PersistenceContext
    EntityManager em;

    public CategorySearch() throws XMLStreamException {
//        this.parsedCategories = new ParseXML().parsStax("files/allegro.xml");
        this.parsedCategories = new CategoryParserManager().parseAndPersist("files/allegro.xml");
//        this.parsedCategories = new ArrayList<>();
    }

    public List<Category> getParsedCategories() {
        return parsedCategories;
    }

    public List<Category> searchCategoryByGivenProduct(String searchedProduct) {
//        ReportPopularProducts reportPopularProducts = new ReportPopularProducts();
//        reportPopularProducts.setProduct(searchedProduct);
//        em.persist(reportPopularProducts);
//TODO Tu będzie metoda wywołująca POSTa informująca moduł raportowy o zajściu zdarzenia - nastąpiło wyszukanie produktu

        SearchEvent searchEvent = new SearchEvent();
        ClientReport clientReport = new ClientReport();

        searchEvent.setProduct(searchedProduct);
        searchEvent.setDate(LocalDate.now());
        clientReport.sendEvent(searchEvent);

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

