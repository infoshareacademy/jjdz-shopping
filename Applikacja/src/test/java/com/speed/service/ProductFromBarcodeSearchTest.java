package com.speed.service;

import com.speed.SearchByBarcode.ProductFromBarcode;
import com.speed.SearchByBarcode.ProductFromBarcodeApp;
import com.speed.model.Category;
import com.speed.model.SearchEvent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.xml.stream.XMLStreamException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ewaw on 15.05.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductFromBarcodeSearchTest {

    @Mock
    EntityManager em;

    @Mock
    ClientReport clientReport;

    @InjectMocks
    CategorySearch categorySearch;



    ProductFromBarcodeApp cut;

    @Before
    public void setup() throws XMLStreamException {
        cut = new ProductFromBarcodeApp();
        cut.categorySearch = categorySearch;
    }

    @Test
    public void testfindKeyWordGivesRightResult() throws Exception {

//        given
//        ProductFromBarcodeApp produktZObrazka = new ProductFromBarcodeApp(); - CUT

        ProductFromBarcode product = cut.findProduct(cut.GetBitMap(getClass().getResource("/barcode_tv.png").getPath()));
        List<Category> checkedCategories = categorySearch.searchCategoryByGivenProduct("LED");

        //        when
        List<Category> tvCategories = product.getProductCategories();

        //        then
        assertEquals("Cos jest nie tak", tvCategories, checkedCategories);

    }


}
