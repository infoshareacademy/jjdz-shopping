package com.speed.model;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ShouldReturnCatElektronika {

    private CategoryTree cut;

    @Test
    public void ShouldReturnCatElektronika(){
//        given
//
//         Hashmap symulujący drzewo kategorii
//          expected: kategoria z nazwą Elektronika

        Map<Integer, Category> categoryMap = new HashMap<>();

        categoryMap.put(1, new Category(1,0,"Elektronika") );
        categoryMap.put(2, new Category(2,1,"LCD") );
        categoryMap.put(3, new Category(3,1,"Plazma") );

        cut = new CategoryTree(categoryMap);


        String expected = "Elektronika";

        // Zrobione z pomocą Adama
//        Category expected = new Category(1, 0, "Elektronika");



//        when

//wywołanie metody wyszukującej kategorię w drzewie na podstawie id kategorii z dostarczonego produktu

        String actual = cut.findCategoryByID(1);


        // Zrobione z pomocą Adama
//        Category actual = cut.findCategoryByID(1);

//        then


//        identyfikator kategorii zaszyty w produkcie ma być równy identyfikatorowi kat. Elektronika z HashMapy
        assertEquals("Blad - wartość inna niż oczekiwana. ", expected, actual);

    }
}