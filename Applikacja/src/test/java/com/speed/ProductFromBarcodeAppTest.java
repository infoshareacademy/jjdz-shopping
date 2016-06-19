package com.speed;


import com.speed.SearchByBarcode.ProductFromBarcode;
import com.speed.SearchByBarcode.ProductFromBarcodeApp;
import com.speed.service.CategorySearch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;


/**
 * Created by ewaw on 28.02.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductFromBarcodeAppTest {

//    @Mock
//    EntityManager em;

    @Mock
    CategorySearch categorySearch;

    @InjectMocks
    ProductFromBarcodeApp cut;

    @Test
    public void testFindProductwithRightPicture() throws Exception {
        //given
        String expectedGTIN = "5907377860327";
        String expectedProductName = "LED1901 produkt";
        String expectedManucafturerName = "MANTA Spółka Akcyjna";
        String fileNameOK = getClass().getResource("/barcode_tv.png").getPath();

        //when
        ProductFromBarcode actual = cut.findProduct(cut.GetBitMap(fileNameOK));

        //then
        assertEquals("Probelm with GTIN", actual.getProductNumber(), expectedGTIN);
        assertEquals("Problem with product name", actual.getProductName(),expectedProductName);
        assertEquals("Problem with product name", actual.getManufacturerName(),expectedManucafturerName);
        System.out.println(actual.getProductNumber() + actual.getProductName() + actual.getManufacturerName());
    }


    @Test (expected = IOException.class)
    public void testFindProductWrongFile() throws IOException, XMLStreamException {
        //given
        String fileNameNotOK = "";

        //when
        ProductFromBarcode actual = cut.findProduct(cut.GetBitMap(fileNameNotOK));

        //then throws IOException
    }

    @Test (expected = IOException.class)
    public void testFindProductNotInDatabese() throws IOException, XMLStreamException {
        //given
        String fileNameNotOK = getClass().getResource("/zxing_barcode_test.jpg").getPath();

        //when
        ProductFromBarcode actual = cut.findProduct(cut.GetBitMap(fileNameNotOK));

        //then throws IOException
    }
//

}