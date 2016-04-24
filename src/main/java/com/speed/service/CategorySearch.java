package com.speed.service;

import com.speed.model.Category;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by damian on 22.04.16.
 */
@Stateless
public class CategorySearch {

    private List<Category> categories;
    private String foundCategory = "";

    public CategorySearch() {
        this.categories = new ArrayList<Category>();

        categories.add(new Category(26013, 0, "Rowery"));
        categories.add(new Category(98553, 0, "Telewizory"));
        categories.add(new Category(64477, 0, "Odzież"));
        categories.add(new Category(12345, 64477, "Spodnie"));
        categories.add(new Category(22334, 26013, "Rowery miejskie"));
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getFoundCategory() {
        return foundCategory;
    }

    public void setFoundCategory(String foundCategory) {
        this.foundCategory = foundCategory;
    }

    public StringBuilder searchCategoryByGivenProduct(String searchedProduct) {

        setFoundCategory("");
        StringBuilder builder = new StringBuilder();
        for (Category cat : categories) {
            if (cat.getCatName().toLowerCase().contains(searchedProduct.toLowerCase())) {
                builder.append("Product can be found in category: " + cat.getCatName() + "<br>");

//                    TODO: insert to database the name of found category instead of below setFoundCategory
                setFoundCategory(cat.getCatName());
            }
        }
        if (getFoundCategory().equals("")) {
            builder.append("No category found for product: " + searchedProduct);
        }
        return builder;
    }
}

