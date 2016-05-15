package com.speed.service;

import com.gargoylesoftware.htmlunit.TextPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.speed.model.Category;
import com.speed.model.ProductFromBarcode;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

/**
 * Created by ewaw on 14.05.16.
 */

@RunWith(Arquillian.class)
public class SearchByBarcodeServletTest {

    @Deployment
    public static WebArchive createDeployment() {
        File[] jars = Maven.resolver().loadPomFromFile("pom.xml")    // tu dodana
                .resolve("com.google.zxing:core", "com.google.zxing:javase").withTransitivity().asFile();

        WebArchive webArchive = ShrinkWrap.create(WebArchive.class)
                .addAsLibraries(jars)
                .addAsResource("META-INF/persistence.xml")
                .addClasses(ProductFromBarcode.class, ProductFromBarcodeApp.class, CategorySearch.class)
                .addClasses(Category.class); //tu dodac moje klasy!

//        List files in the archive (wylistuje co jest w archiwum)
//        System.out.println("webArchive.toString(true) = " + webArchive.toString(true));
        return webArchive;
    }



    @Test
    @RunAsClient
    public void should_(@ArquillianResource URL baseUrl) throws IOException {}




}