package com.speed.service;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
//import com.speed.model.Product;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ewa on 2/21/16.
 */
public class ProductApp {

    private Scanner sc = new Scanner(System.in);

    public String /*Product*/ getProduct(){
        String fileName = getFilePath();
        BinaryBitmap myMap = GetBitMapfromFile(fileName);
        MultiFormatReader reader = new MultiFormatReader();
        Result result = null;
        try {
            result = reader.decode(myMap);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        if (result == null) throw new AssertionError();

        String gtin = result.getText();  //toString????

        //druga czesc - wyciagniecie info z API

        return gtin;
    }

    private BinaryBitmap GetBitMapfromFile(String fileName) {
        File img = new File(fileName);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(img);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (bufferedImage == null) {
            throw new AssertionError();
        }

        HybridBinarizer hb = new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage));

        return new BinaryBitmap(hb);
    }


    public String getFilePath() {
        System.out.println("Podaj sciezke pliku: ");
        return getUserInput();
    }

    public String getUserInput() {
        return sc.nextLine().trim();
    }
}
