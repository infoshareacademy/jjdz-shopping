package com.speed.dao;

import com.speed.model.ReportPopularProducts;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by piotr on 14.05.16.
 */
@Stateless
public class PopularProductsDao implements  Dao<ReportPopularProducts> {

    @PersistenceContext
    EntityManager em;

    @Override
    public void create(ReportPopularProducts object) {
        em.persist(object);

    }

    @Override
    public void upade(ReportPopularProducts object) {

    }

    @Override
    public List<ReportPopularProducts> list() {
        return null;
    }

    @Override
    public ReportPopularProducts getById(int catId) {
        return null;
    }

    @Override
    public void remove(int catId) {

    }
}
