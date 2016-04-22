package com.speed.model;

import com.speed.service.CategorySearch;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by raker on 22.04.16.
 */
public class CategorySearchTest {
    @Test
    public void willReturnCategoryNameWhenLowerCaseProductFound() {
        // given
        CategorySearch categorySearcher = new CategorySearch();

        // when
        categorySearcher.searchCategoryByGivenProduct("rower");

        // then
        assertTrue(categorySearcher.getFoundCategory(), true);
    }

    @Test
    public void willReturnCategoryNameWhenUpperCaseProductFound() {
        // given
        CategorySearch categorySearcher = new CategorySearch();

        // when
        categorySearcher.searchCategoryByGivenProduct("ROWER");

        // then
        assertTrue(categorySearcher.getFoundCategory(), true);
    }

    @Test
    public void willReturnMessageWhenProductNotFound() {
        // given
        CategorySearch categorySearcher = new CategorySearch();

        // when
        categorySearcher.searchCategoryByGivenProduct("telefon");

        // then
        assertTrue(categorySearcher.getFoundCategory(), true);
    }


}
