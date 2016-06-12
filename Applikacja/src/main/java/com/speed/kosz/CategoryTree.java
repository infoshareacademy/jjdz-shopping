package com.speed.kosz;

import com.speed.model.Category;

import java.util.Map;

public class CategoryTree{
    Map<Integer, Category> categoryMap;

    public CategoryTree(Map<Integer, Category> categoryMap) {
        this.categoryMap = categoryMap;
    }

    public String findCategoryByID(int id) {
        String catName = "";

        for ( int i=1; i <= categoryMap.size(); i++ ) {
            Category value = categoryMap.get(i);
            if(value.getCatId() == id){
                catName  = value.getCatName();
            }
        }
     return catName;
//        return categoryMap.get(id);
    }
}
