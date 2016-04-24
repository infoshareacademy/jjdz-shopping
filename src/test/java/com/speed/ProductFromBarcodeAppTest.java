package com.speed;


import com.speed.model.ProductFromBarcode;
import com.speed.service.ProductFromBarcodeApp;
import org.junit.Test;

import java.io.IOException;


/**
 * Created by ewaw on 28.02.16.
 */
public class ProductFromBarcodeAppTest {

    private ProductFromBarcodeApp cut = new ProductFromBarcodeApp();

    @Test
    public void testFindProductwithRightPicture() throws Exception {
        //given
        String expectedGTIN = "08717644419595";
        String expectedProductName = "TIMOTEI SZAMPON PPRZECIWŁUPIEŻOWY DLA MĘŻCZYZN 250ml";
        String expectedManucafturerName = "Unilever Polska Sp. z o.o.";

        String fileNameOK = "/home/ewaw/Workspace/jjdz-shopping/src/test/resources/barcode.png";

        //when
        ProductFromBarcode actual = cut.findProduct(cut.GetBitMap(fileNameOK));

        //then
//        assertEquals("Probelm with GTIN", actual.getProductNumber(), expectedGTIN);
//        assertEquals("Problem with product name", actual.getProductName(),expectedProductName);
//        assertEquals("Problem with product name", actual.getManufacturerName(),expectedManucafturerName);
//        System.out.println(actual.getProductNumber() + actual.getProductName() + actual.getManufacturerName());
    }


    @Test (expected = IOException.class)
    public void testFindProductWrongFile() throws IOException {
        //given
        String fileNameNotOK = "/home/ewaw/Workspace/jjdz-shopping/src/test/resources/barecode.png";

        //when
        ProductFromBarcode actual = cut.findProduct(cut.GetBitMap(fileNameNotOK));

        //then throws IOException
    }

    @Test (expected = IOException.class)
    public void testFindProductNotInDatabese() throws IOException {
        //given
        String fileNameNotOK = "/home/ewaw/Workspace/jjdz-shopping/src/test/resources/files/zxing_barcode_test.jpg";

        //when
        ProductFromBarcode actual = cut.findProduct(cut.GetBitMap(fileNameNotOK));

        //then throws IOException
    }

}