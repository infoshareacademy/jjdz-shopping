package com.speed.kosz;

import com.speed.kosz.CategoryTemp;

import java.util.*;

import static com.speed.kosz.CategoryTemp.addCategoryToMap;
import static com.speed.kosz.CategoryTemp.catFrom;




//Przykładowe pytania
//    Wybór ogólnej kategorii po uruchomieniu aplikacji
//



public class Question {

    public static void main(String[] args) {
        //displays available categories with their IDs
        addCategoryToMap();
    }

    public void addToQuestionMap() {
        String question = "Czy TV ma być do rozrywki?";

        CategoryTemp c1 = new CategoryTemp("c1", "LCD");

        // creates a hash map
        Map<String, List<CategoryTemp>> questionMap = new HashMap<>();

        // put elements (answers and matching categories) to the map
        questionMap.put("tak", Arrays.asList(c1));

        //alternatywnie

        questionMap.put("tak", new ArrayList<CategoryTemp>());

        //uzupenianie listy kategorii
        List<CategoryTemp> list = questionMap.get("tak");

        list.add(catFrom("c1", "LCD"));
        list.add(catFrom("c2", "LCD"));
        list.add(catFrom("c3", "LCD"));



    }

}
