package com.speed.kosz.repository;


import com.speed.model.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by piotr on 14.05.16.
 */
@Stateless
public class CategoryDao {

    @PersistenceContext
    EntityManager em;


    public List<Category> getListCategorys() {
        List<Category> c = em.createQuery("from Category").getResultList();
        return c;
    }


}
