package com.speed.service;

import com.speed.model.ProductFromBarcode;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.runner.RunWith;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by ewaw on 14.05.16.
 */

@RunWith(Arquillian.class)
public class SearchByBarcodeServletTest {

    @Deployment
    public static WebArchive createDeployment() {
        File[] jars = Maven.resolver().loadPomFromFile("pom.xml")    // tu dodana
                .resolve("com.google.zxing:core").withTransitivity().asFile();

        WebArchive webArchive = ShrinkWrap.create(WebArchive.class)
                .addAsLibraries(jars)
                .addClasses(ProductFromBarcode.class); //tu dodac moje klasy!


//        List files in the archive (wylistuje co jest w archiwum)
//        System.out.println("webArchive.toString(true) = " + webArchive.toString(true));
        return webArchive;
    }
}