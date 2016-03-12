package com.speed.model;


import java.util.HashMap;

/**
 * Created by slaw on 13.02.16.
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Category {

    int id;
    int parentId;
    String categoryName;

    public Category(int id, int parentId, String categoryName) {
        this.id = id;
        this.parentId = parentId;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public int getParentId() {
        return parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (parentId != category.parentId) return false;
        return categoryName.equals(category.categoryName);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + parentId;
        result = 31 * result + categoryName.hashCode();
        return result;
    }
}

