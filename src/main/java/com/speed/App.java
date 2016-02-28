package com.speed;

import com.speed.model.AppEntryPoint;
import com.speed.model.Shop;
import com.speed.model.TV;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Shop shop = new Shop() {
            @Override
            public List<URI> search(TV tv) {
                return Arrays.asList(
                        URI.create("https://kjhkjh.kjhk.pl"),
                        URI.create("https://kjhkjh.fsdfsdkjhk.pl")
                );
            }
        };

        AppEntryPoint appEntryPoint = new AppEntryPoint(shop, System.out, new Scanner(System.in));
        System.out.println(appEntryPoint.searchShops());
    }

}
