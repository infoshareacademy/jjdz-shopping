package com.speed.service;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.speed.model.Product;

import java.util.Scanner;

/**
 * Created by ewa on 2/21/16.
 */
public class ProductApp {

    private Scanner sc = new Scanner(System.in);

    public Product getProduct(){
        String fileName = getFilePath();
        BinaryBitmap myMap = GetBitMapfromFile(fileName);
        MultiFormatReader reader = new MultiFormatReader();
        try {
            Result result = reader.decode(myMap);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private BinaryBitmap GetBitMapfromFile(String fileName) {
 //       wczytuje z pliku obrazek i zwraca w postaci BinaryBitmap
        return null;
    }


    public String getFilePath() {
        System.out.println("Podaj sciezke pliku: ");
        return getUserInput();
    }

    public String getUserInput() {
        return sc.nextLine().trim();
    }
}
