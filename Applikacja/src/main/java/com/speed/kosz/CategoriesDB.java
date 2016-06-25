package com.speed.kosz;


import com.speed.model.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CategoriesDB {

    @PersistenceContext
    EntityManager em;

    public void saveToDbParsedCategories(List<Category> categoryList) {
        categoryList.stream().forEach(category -> em.persist(category));
    }

}
