package com.speed.SearchByBarcode;


import com.speed.model.Category;

import java.util.List;

/**
 * Created by ewaw on 13.02.16.
 */

//@Stateless
public class ProductFromBarcode {


    private String ProductName;
    private String ProductNumber;
    private String ManufacturerName;
    private String ProductKeyWord;
    private List<Category> ProductCategories;


    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductNumber() {
        return ProductNumber;
    }

    public void setProductNumber(String productNumber) {
        ProductNumber = productNumber;
    }

    public String getManufacturerName() {
        return ManufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        ManufacturerName = manufacturerName;
    }

    public List<Category> getProductCategories() {
        return ProductCategories;
    }

    public void setProductCategories(List<Category> productCategories) {
        ProductCategories = productCategories;
    }

    public String getProductKeyWord() {
        return ProductKeyWord;
    }

    public void setProductKeyWord(String productKeyWord) {
        ProductKeyWord = productKeyWord;
    }
}
