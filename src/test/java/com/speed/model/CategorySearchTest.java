package com.speed.model;

import com.speed.service.CategorySearch;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by raker on 22.04.16.
 */
public class CategorySearchTest {
    @Test
    public void should_return_not_empty_list_of_found_categories() throws XMLStreamException {
        // given
        CategorySearch categorySearcher = new CategorySearch();

        // when
        List<Category> foundCategories = categorySearcher.searchCategoryByGivenProduct("rower");

        // then
        assertTrue(foundCategories.size() > 0);
    }

    @Test
    public void willReturnCategoryNameWhenUpperCaseProductFound() throws XMLStreamException {
        // given
        CategorySearch categorySearcher = new CategorySearch();

        // when
        List<Category> foundCategories = categorySearcher.searchCategoryByGivenProduct("ROWER");

        // then
        assertTrue(foundCategories.size() > 0);
    }

    @Test
    public void willReturnMessageWhenProductNotFound() throws XMLStreamException {
        // given
        CategorySearch categorySearcher = new CategorySearch();

        // when
        List<Category> foundCategories = categorySearcher.searchCategoryByGivenProduct("blabla");

        // then
        assertTrue(foundCategories.size() == 0);
    }


}
