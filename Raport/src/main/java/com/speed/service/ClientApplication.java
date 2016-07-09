package com.speed.service;

import com.speed.model.SearchEvent;

import javax.ejb.Stateless;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@Stateless
public class ClientApplication {

    private final String baseUrl = "http://jboss-report:8080/shopping";

    public void sendEvent(SearchEvent searchEvent){
        URI uri = UriBuilder.fromUri(baseUrl)
                .segment("api").segment("reports").segment("search").build();

        Response post = ClientBuilder.newClient()
                .target(uri)
                .request()
                .post(Entity.json(searchEvent));
    }

}
