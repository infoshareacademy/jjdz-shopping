package com.speed;


import com.speed.model.Product;
import com.speed.service.ProductApp;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by ewaw on 28.02.16.
 */
public class ProductAppTest {

    private ProductApp cut = new ProductApp();

    @Test
    public void testFindProductwithRightPicture() throws Exception {
        //given
        String expectedGTIN = "08717644419595";
        String expectedProductName = "TIMOTEI SZAMPON PPRZECIWŁUPIEŻOWY DLA MĘŻCZYZN 250ml";
        String expectedManucafturerName = "Unilever Polska Sp. z o.o.";

        String fileNameOK = "/home/ewaw/Workspace/jjdz-shopping/src/main/resources/files/barcode.png";

        //when
        Product actual = cut.findProduct(fileNameOK);

        //then
        assertEquals("Probelm with GTIN", actual.getProductNumber(), expectedGTIN);
        assertEquals("Problem with product name", actual.getProductName(),expectedProductName);
        assertEquals("Problem with product name", actual.getManufacturerName(),expectedManucafturerName);
//        System.out.println(actual.getProductNumber() + actual.getProductName() + actual.getManufacturerName());
    }


    @Test (expected = IOException.class)
    public void testFindProductWrongFile() throws IOException {
        //given
        String fileNameNotOK = "/home/ewaw/Workspace/jjdz-shopping/src/main/resources/files/barecode.png";

        //when
        Product actual = cut.findProduct(fileNameNotOK);

        //then throws IOException
    }

    @Test (expected = IOException.class)
    public void testFindProductNotInDatabese() throws IOException {
        //given
        String fileNameNotOK = "/home/ewaw/Workspace/jjdz-shopping/src/main/resources/files/zxing_barcode_test.jpg";

        //when
        Product actual = cut.findProduct(fileNameNotOK);

        //then throws IOException
    }

}