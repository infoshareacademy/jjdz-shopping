package com.speed.model;

import java.io.InputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.List;
import java.util.Scanner;

public class AppEntryPoint {

    private final PrintStream out;
    private final Scanner scanner;

    public AppEntryPoint(Shop shop, PrintStream out, Scanner scanner) {
        this.shop = shop;
        this.out = out;
        this.scanner = scanner;
    }

    private final Shop shop;
//    private final PrintStream output;

    public List<URI> searchShops(){
        TV tv = getTv();
        return shop.search(tv);
    }

    // print TVs and allows to choose one of a kind
    private TV getTv(){

        out.println("Wybierz rodzaj TV:\n" +
                "1 - LCD\n" +
                "2 - Plazma\n" +
                "3 - Kineskop");

        Scanner sc = scanner;
        String choice = sc.next();

        switch(choice){
            case "1":
                out.println("LCD");
                LCD lcd1 = new LCD();
                lcd1.setCena(100);
                lcd1.setIs3D(true);

               return lcd1;
//                break;
            case "2":
                out.println("plazma");
//                break;
            case "3":
                out.println("kineskop");
//                break;
            default:
                throw new RuntimeException("wrong choice: " + choice);
        }

    }

}
