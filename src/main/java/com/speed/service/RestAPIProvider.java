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

        String adresPar = "?";

        for (Map.Entry<String, String> entry :
                params.entrySet()) {
            adresPar += entry.getKey()+"="+entry.getValue()+"&";
        }

        return adresPar .substring(0, adresPar.length()-1);
    }

    //stworzyc url bazujac na 1 i 2, http://api3.produktywsieci.pl/PublicService.svc/rest/xml/GetProductByGTIN?gs1Key=*****&gtin=*****&ip=*****&geoloc=*****&longitude=*****&latitude=*****

    public String sendRestApiRequest() throws IOException {

        URL url = new URL(this.RestRequestAddres + CreateParameters());

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        int responseCode = conn.getResponseCode();

        // if connections failed
        if (responseCode != 200) {
            throw new IOException(conn.getResponseMessage());
        }

        // Buffer the result into a string
        StringBuilder bufferStr = new StringBuilder();

        try(InputStream inputStream = conn.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader buffer = new BufferedReader(reader)) {

            String line;

            // all lines to bufferStr
            while ((line = buffer.readLine()) != null) {
                bufferStr.append(line);
            }
            buffer.close();
        }
        catch(IOException e){
            throw new IOException("Error during reading REST information from URL "+url+". Inner message: "+e.getMessage());
        }

        conn.disconnect();
        return bufferStr.toString();
    }

}
