package com.speed;

import com.speed.dao.CategoryDao;
import com.speed.dao.PopularProductsDao;
import com.speed.model.Category;
import com.speed.model.ReportPopularProducts;
import com.speed.service.CategorySearch;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.xml.stream.XMLStreamException;

/**
 * Created by piotr on 14.05.16.
 */

public class Main {





    public static void main(String[] args) {
//        String cos = "test";
//
//        EntityManagerFactory ef = Persistence.createEntityManagerFactory("ShoppingDB");
//        EntityManager em = ef.createEntityManager();
//
//
//
//        ReportPopularProducts reportPopularProducts = new ReportPopularProducts();
//        reportPopularProducts.setProduct("test");
//
//        em.getTransaction().begin();
//        em.persist(reportPopularProducts);
//        em.flush();
//
//
//
//
//
//
//
//
////        CategorySearch categorySearch = new CategorySearch();
////        categorySearch.searchCategoryByGivenProduct(cos);
////        Query popularProductQuery = em.createQuery("select r from ReportPopularProducts r where r.product = " + cos );
////
////
////
////
////        System.out.println(popularProductQuery);
//
    }
}
