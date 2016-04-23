package com.speed.model;

public class DataFromSearchByProductForm {

    private String searchedProduct = "";

    public DataFromSearchByProductForm(String searchedProduct) {
        this.searchedProduct = searchedProduct;
    }

    public String getSearchedProduct() {
        return searchedProduct;
    }

    public void setSearchedProduct(String searchedProduct) {
        this.searchedProduct = searchedProduct;
    }
}
