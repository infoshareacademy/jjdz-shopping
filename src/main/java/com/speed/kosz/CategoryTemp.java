package com.speed.kosz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CategoryTemp {

    private String categoryID;
    private String categoryName;

    public CategoryTemp(String categoryID, String categoryName){
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public static void addCategoryToMap(){

        HashMap hmCategory = new HashMap();

        hmCategory.put("c1", "Kineskopowe");
        hmCategory.put("c2", "LCD");
        hmCategory.put("c3", "Plazmowe");

        Set set = hmCategory.entrySet();
        Iterator i = set.iterator();

        while(i.hasNext()){
            Map.Entry entry = (Map.Entry)i.next();
            System.out.println(entry.getKey() + ": ");
            System.out.println(entry.getValue());
        }
    }


    //static factory method
    public static CategoryTemp catFrom(String c1, String lcd) {
        return new CategoryTemp(c1, lcd);
    }
}
