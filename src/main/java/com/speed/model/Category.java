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

    private int catId;
    private String catName;
    private int catParent;
    private int catPosition;
    private int catIsProductCatalogueEnabled;

    public Category(int catId, int catParent, String catName) {
        this.catId = catId;
        this.catName = catName;
        this.catParent = catParent;
    }

    public Category() {

    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatParent() {
        return catParent;
    }

    public void setCatParent(int catParent) {
        this.catParent = catParent;
    }

    public int getCatPosition() {
        return catPosition;
    }

    public void setCatPosition(int catPosition) {
        this.catPosition = catPosition;
    }

    public int getCatIsProductCatalogueEnabled() {
        return catIsProductCatalogueEnabled;
    }

    public void setCatIsProductCatalogueEnabled(int catIsProductCatalogueEnabled) {
        this.catIsProductCatalogueEnabled = catIsProductCatalogueEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (getCatId() != category.getCatId()) return false;
        if (getCatParent() != category.getCatParent()) return false;
        if (getCatPosition() != category.getCatPosition()) return false;
        if (getCatIsProductCatalogueEnabled() != category.getCatIsProductCatalogueEnabled()) return false;
        return getCatName().equals(category.getCatName());

    }

    @Override
    public int hashCode() {
        int result = getCatId();
        result = 31 * result + getCatName().hashCode();
        result = 31 * result + getCatParent();
        result = 31 * result + getCatPosition();
        result = 31 * result + getCatIsProductCatalogueEnabled();
        return result;
    }
}

