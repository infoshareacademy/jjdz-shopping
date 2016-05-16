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
    public void should_return_not_empty_list_of_found_categories_searched_by_uppercase() throws XMLStreamException {
        // given
        CategorySearch categorySearcher = new CategorySearch();

        // when
        List<Category> foundCategories = categorySearcher.searchCategoryByGivenProduct("ROWER");

        // then
        assertTrue(foundCategories.size() > 0);
    }

    @Test
    public void should_return_empty_list_if_category_not_found() throws XMLStreamException {
        // given
        CategorySearch categorySearcher = new CategorySearch();

        // when
        List<Category> foundCategories = categorySearcher.searchCategoryByGivenProduct("blabla");

        // then
        assertTrue(foundCategories.size() == 0);
    }

    @Test
    public void should_return_not_empty_list_of_found_subcategories() throws XMLStreamException {
        //given
        CategorySearch searchSubcategories = new CategorySearch();

        //when
        List<Category> childrens = searchSubcategories.findCategoryChildren(5560); //5560 - Motorowery; Contains 2 childrens: "Nowe", "Używane"

        //then
        for (Category child:childrens) {
            System.out.println("Children: ID " + child.getCatId() + ", " + child.getCatName());
        }
        assertTrue(childrens.size() > 0);
    }

}
