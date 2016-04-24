package com.speed.model;


/**
 * Created by ewaw on 13.02.16.
 */

public class ProductFromBarcode {


    private String ProductName;
    private String ProductNumber;
    private String ManufacturerName;


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
}
