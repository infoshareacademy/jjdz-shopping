package com.speed.dao;


import com.speed.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by piotr on 14.05.16.
 */@Stateless
public class CategoryDao implements Dao<Category> {

    private static final Logger logger = LoggerFactory.getLogger(CategoryDao.class);

    @PersistenceContext
    EntityManager em;


    @Override
    public void create(Category category) {
        em.persist(category);

    }

    @Override
    public void upade(Category category) {
        em.merge(category);


    }

    @Override
    public List<Category> list() {
        List<Category> c = em.createQuery("from Category").getResultList();
        return c;
    }

    @Override
    public Category getById(int catId) {
        return em.find(Category.class, catId);

    }

    @Override
    public void remove(int catId) {
        em.remove(catId);


    }
}
