package com.speed;

import com.speed.dao.CategoryDao;
import com.speed.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by piotr on 14.05.16.
 */
public class Main {


    public static void main(String[] args) {

        CategoryDao categorynDao = new CategoryDao();

        Category category = new Category();
        category.setCatId(2);
        category.setCatName("Test2");
        categorynDao.create(category);




        System.out.println(categorynDao);

    }
}
