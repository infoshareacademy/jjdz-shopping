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
}

