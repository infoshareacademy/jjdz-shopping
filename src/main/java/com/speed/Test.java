package com.speed;

import com.speed.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by piotr on 02.05.2016.
 */
public class Test {


    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShoppingDB");
        EntityManager em = emf.createEntityManager();

        Category category = new Category();
        category.setCatId(1);
        category.setCatName("Test");
        category.setCatParent(11);
        category.setCatPosition(111);

        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();

        category = em.find(Category.class,1);
        System.out.println(category);


    }
}
