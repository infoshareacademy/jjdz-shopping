package com.speed.dao;


import com.speed.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by piotr on 14.05.16.
 */@Stateless
public class CategoryDao implements Dao<Category> {

    private static final Logger logger = LoggerFactory.getLogger(CategoryDao.class);

//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShoppingDB");
    @PersistenceContext
    EntityManager em;
//    EntityManager em = emf.createEntityManager();


    @Override
    public void create(Category category) {
        em.persist(category);

    }

    @Override
    public void upade(Category category) {
        em.getTransaction().begin();
        em.merge(category);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<Category> list() {
        List<Category> c = em.createQuery("from Category").getResultList();
        return c;
    }

    @Override
    public Category getById(int catId) {
        em.getTransaction().begin();
        em.find(Category.class, catId);
        em.getTransaction().commit();
        em.close();

        return null;
    }

    @Override
    public void remove(int catId) {
        em.getTransaction().begin();
        em.remove(catId);
        em.getTransaction().commit();
        em.close();

    }
}
