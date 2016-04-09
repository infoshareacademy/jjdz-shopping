package com.speed.model;

import org.junit.Test;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AppEntryPointTest {

    @Test
    public void testSearchShops() throws Exception {

        Shop shop = new Shop() {
            @Override
            public List<URI> search(TV tv) {
                return Arrays.asList(
                        URI.create("https://kjhkjh.kjhk.pl"),
                        URI.create("https://kjhkjh.fsdfsdkjhk.pl")
                );
            }
        };

        AppEntryPoint aep = new AppEntryPoint(shop, System.out, Arrays.asList("1").iterator());

        List<URI> uris = aep.searchShops();
//        assertThat(uris, org.hamcrest.Matchers.hasSize(2));
    }
}