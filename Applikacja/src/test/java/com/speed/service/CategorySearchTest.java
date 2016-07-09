package com.speed.service;

import com.speed.model.Category;
import com.speed.model.SearchEvent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

/**
 * Created by ewa on 7/1/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class CategorySearchTest {

    @Mock
    ClientReport clientReport;

    @Mock
    SearchEvent searchEvent;

    @InjectMocks
    CategorySearch categorySearch;


    private Category category1 = new Category(1111, 2222, "LED");
    private Category category2 = new Category(3333, 1111, "LED_A");
    private Category category3 = new Category(4444, 1111, "LED_B");
    private List<Category> Categories = new ArrayList<>();

    @Test
    public void checkIfReturnCategoriesIncludingSearchedProduct() {
//        given
        String searchedProduct = "Rower";

//        when
        List<Category> foundCategories = categorySearch.searchCategoryByGivenProduct(searchedProduct);

//        then
        for (Category category : foundCategories)
            assertThat(category.getCatName().toLowerCase(), containsString(searchedProduct.toLowerCase()));

    }

    @Test
    public void ifCategoryNotFoundReturnEmptyList() {
//        given
        String searchedProduct = "XBZXBZ";

//        when
        List<Category> foundCategories = categorySearch.searchCategoryByGivenProduct(searchedProduct);

//        then
        assertTrue(foundCategories.size() == 0);
    }


    @Test
    public void findCategoryChildrenforRowerSearch() throws Exception {
//        given
        String searchedProduct = "Rower";
        List<Category> CategoriesRower = categorySearch.searchCategoryByGivenProduct(searchedProduct);
        Category category = CategoriesRower.get(1);
        int catId = category.getCatId();

//        when
        List<Category> result = categorySearch.findCategoryChildren(catId);

//        then
        for (Category cat : result)
            assertEquals(cat.getCatParent(), catId);
    }

    @Test
    public void catgoryShouldBeFoundByIdforRowerSearch() throws Exception {
//        given
        String searchedProduct = "Rower";
        List<Category> CategoriesRower = categorySearch.searchCategoryByGivenProduct(searchedProduct);
        Category category = CategoriesRower.get(1);
        int catId = category.getCatId();

//        when
        Category cat = categorySearch.findCategoryById(catId);

//        then
        assertEquals(cat, category);
    }



    @Before
    public void init_cat() {
        Categories.add(category1);
        Categories.add(category2);
        Categories.add(category3);
    }

    @Test
    public void findCategoryChildrenforLED() throws Exception {
//        given
        categorySearch.setParsedCategories(Categories);
        int catId = category1.getCatId();

//        when
        List<Category> result = categorySearch.findCategoryChildren(catId);
        Categories.remove(category1);

//        then
        assertEquals(result, Categories);
    }


    @Test
    public void findCategoryNoChildren() {
//        given
        categorySearch.setParsedCategories(Categories);
        int catId = category2.getCatId();

//        when
        List<Category> result = categorySearch.findCategoryChildren(catId);

//        then
        assertTrue(result.size() == 0);
    }


    @Test
    public void catgoryShouldBeFoundById() throws Exception {
//        given
        categorySearch.setParsedCategories(Categories);
        int catId = category1.getCatId();

//        when
        Category category = categorySearch.findCategoryById(catId);

//        then
        assertEquals(category, category1);
    }


    @Test
    public void showPathforRowerSearch() {
//        given
        String searchedProduct = "Rower";
        List<Category> CategoriesRower = categorySearch.searchCategoryByGivenProduct(searchedProduct);
        Category category = CategoriesRower.get(1);
        int catId = category.getCatId();

//        when
        StringBuilder builder = categorySearch.showPath(catId);

//        then
        assertThat(builder.toString().toLowerCase(), containsString(searchedProduct.toLowerCase()));

    }

}