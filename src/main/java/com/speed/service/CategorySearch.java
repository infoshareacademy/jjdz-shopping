package com.speed.service;

import com.speed.model.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by damian on 22.04.16.
 */
public class CategorySearch {

    private List<Category> categoryList;
    private String foundCategory = "";

    public CategorySearch(){
        this.categoryList = new ArrayList<Category>(Arrays.<Category>asList());

        categoryList.add(new Category(26013,0,"Rowery"));
        categoryList.add(new Category(98553,0,"Telewizory"));
        categoryList.add(new Category(64477,0,"Odzież"));
        categoryList.add(new Category(12345,64477,"Spodnie"));
        categoryList.add(new Category(22334,26013,"Rowery miejskie"));
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public String getFoundCategory() {
        return foundCategory;
    }

    public void setFoundCategory(String foundCategory) {
        this.foundCategory = foundCategory;
    }

    public String searchCategoryByGivenProduct(String searchedProduct){

//        System.out.println("Search for product: ");
//        Scanner userInput = new Scanner(System.in);
//        String searchedProduct = userInput.nextLine();


        for (Category cat:categoryList) {
                if(cat.getCatName().toLowerCase().contains(searchedProduct.toLowerCase())){
                    System.out.println("Product " + searchedProduct + " can be found in category: " + cat.getCatName());
                    setFoundCategory(cat.getCatName());
                }
            }
        if(getFoundCategory().equals("")){
            System.out.println("No category found for product: " + searchedProduct);
        }
        return getFoundCategory();
        }
    }

