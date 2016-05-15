package com.speed.kosz;

//import com.speed.model.LCD;

import java.io.PrintStream;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

public class AppEntryPoint {

    private final PrintStream out;
    private final Iterator<String> scanner;

    public AppEntryPoint(Shop shop, PrintStream out, Iterator<String> scanner) {
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

        String choice = scanner.next();

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

    public static interface Shop {
        List<URI> search(TV tv);
    }
}
