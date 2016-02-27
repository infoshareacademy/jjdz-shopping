package com.speed.model;


import java.util.HashMap;

/**
 * Created by slaw on 13.02.16.
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Category {



    public static void main(String[] args) {
        //displays available categories with their IDs

       /* TV tv1= new TV();

        tv1.setCena(1500);
        tv1.setNowy(true);
        tv1.setFormat("16:9",1);*/

        TV tv2 = new TV(2500,true,"4:3",1);
        LCD lcd1 = new LCD();

        lcd1.setCena(900);
        lcd1.setOdswiezanie("100Hz",1);


    }


    //category properitis
    private String categoryID;
    private String categoryName;

    //Construktor
    public Category(String categoryID, String categoryName){

        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    //gets
    public String getCategoryID() {return categoryID;}
    public String getCategoryName() {return categoryName;}

    //Temporaty method for adding category
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

