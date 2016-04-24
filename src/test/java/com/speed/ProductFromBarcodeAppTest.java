package com.speed;


import com.speed.model.ProductFromBarcode;
import com.speed.service.ProductFromBarcodeApp;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


/**
 * Created by ewaw on 28.02.16.
 */
public class ProductFromBarcodeAppTest {

    private ProductFromBarcodeApp cut = new ProductFromBarcodeApp();

    @Test
    public void testFindProductwithRightPicture() throws Exception {
        //given
        String expectedGTIN = "5907377860327";
        String expectedProductName = "LED1901 produkt";
        String expectedManucafturerName = "MANTA Spółka Akcyjna";
        String fileNameNotOK = getClass().getResource("/barcode_tv.png").getPath();

        //when
        ProductFromBarcode actual = cut.findProduct(cut.GetBitMap(fileNameNotOK));

        //then
        assertEquals("Probelm with GTIN", actual.getProductNumber(), expectedGTIN);
        assertEquals("Problem with product name", actual.getProductName(),expectedProductName);
        assertEquals("Problem with product name", actual.getManufacturerName(),expectedManucafturerName);
        System.out.println(actual.getProductNumber() + actual.getProductName() + actual.getManufacturerName());
    }


    @Test (expected = IOException.class)
    public void testFindProductWrongFile() throws IOException {
        //given
        String fileNameNotOK = "";

        //when
        ProductFromBarcode actual = cut.findProduct(cut.GetBitMap(fileNameNotOK));

        //then throws IOException
    }

    @Test (expected = IOException.class)
    public void testFindProductNotInDatabese() throws IOException {
        //given
        String fileNameNotOK = getClass().getResource("/zxing_barcode_test.jpg").getPath();

        //when
        ProductFromBarcode actual = cut.findProduct(cut.GetBitMap(fileNameNotOK));

        //then throws IOException
    }

}