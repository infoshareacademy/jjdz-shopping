package com.speed.service;

import com.speed.dao.CategoryDao;
import com.speed.dao.PopularProductsDao;
import com.speed.model.Category;
import com.speed.model.ReportPopularProducts;
import com.speed.parsingutils.ParseXML;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.stream.XMLStreamException;
import java.util.*;

/**
 * Created by damian on 22.04.16.
 */
@Stateless
public class CategorySearch {

    final static Logger logger = Logger.getLogger(CategorySearch.class);

    private List<Category> parsedCategories;

    @PersistenceContext
    EntityManager em;

    public CategorySearch() throws XMLStreamException {
        this.parsedCategories = new ParseXML().parsStax("files/allegro.xml");

    }

    public List<Category> getParsedCategories() {
        return parsedCategories;
    }

    public List<Category> searchCategoryByGivenProduct(String searchedProduct) {
        ReportPopularProducts reportPopularProducts = new ReportPopularProducts();
        reportPopularProducts.setProduct(searchedProduct);
        em.persist(reportPopularProducts);

        //
        List<ReportDTO> list = em.createQuery("select new com.speed.service.ReportDTO(p.product, count(p)) " +
                "from ReportPopularProducts p group by p.product", ReportDTO.class)
                .getResultList();
        System.out.println("list = " + list);
        //

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

