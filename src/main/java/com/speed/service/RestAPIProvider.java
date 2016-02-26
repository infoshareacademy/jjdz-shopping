package com.speed.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by ewa on 2/23/16.
 */
public class RestAPIProvider {
    /*
    1. adres do zapytan restowych - pole String "http://api3.produktywsieci.pl/PublicService.svc/rest/xml/GetProductByGTIN"
    2. slownik zmiennych z parametrami
    3. metoda sentRestApiRequest (przyklad http://rest.elkstein.org/2008/02/using-rest-in-java.html), w pierwszej linjce metody createURLPath z obiektow 1 i 2
     */

    private Map<String, String> params = new HashMap<String, String>();
    private String RestRequestAddres = new String();

    public RestAPIProvider(Map<String, String> params, String RestRequestAddres){
        this.RestRequestAddres = RestRequestAddres;
        this.params = params;
    }
    public RestAPIProvider(Map<String, String> params){
        this.RestRequestAddres = "http://api3.produktywsieci.pl/PublicService.svc/rest/xml/GetProductByGTIN";
        this.params = params;
    }


    public void setRestRequestAddres(String restRequestAddres) {
        RestRequestAddres = restRequestAddres;
    }
    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    private String CreateParameters() {
        //tworzenie lancucha z parametrow podanych w mapie param
        return null;
    }
    String urlParam;

    //stworzyc urlStr bazujac na 1 i 2, http://api3.produktywsieci.pl/PublicService.svc/rest/xml/GetProductByGTIN?gs1Key=*****&gtin=*****&ip=*****&geoloc=*****&longitude=*****&latitude=*****

    public static String sendRestApiRequest() throws IOException {

        String urlStr = null;
        URL url = new URL(urlStr);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        int responseCode = conn.getResponseCode();

        // if connections failed
        if (responseCode != 200) {
            throw new IOException(conn.getResponseMessage());
        }

        // Buffer the result into a string
        InputStream inputStream = conn.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader buffer = new BufferedReader(reader);
        StringBuilder bufferStr = new StringBuilder();

        String line;

        // all lines to bufferStr
        while ((line = buffer.readLine()) != null) {
            bufferStr.append(line);
        }
        buffer.close();

        conn.disconnect();
        return bufferStr.toString();
    }

}
