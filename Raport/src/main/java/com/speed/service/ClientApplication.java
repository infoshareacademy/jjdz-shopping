package com.speed.service;

import com.speed.model.UsersData;

import javax.ejb.Stateless;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

@Stateless
public class ClientApplication {

    private final String baseUrl = "http://jboss:8080/jjdz-shopping-1.0-SNAPSHOT";

    public List<UsersData> askForEmails(){
        URI uri = UriBuilder.fromUri(baseUrl)
                .segment("api").segment("application").segment("usersEmails").build();

        List<UsersData> get = ClientBuilder.newClient()
                .target(uri)
                .request()
                .get().readEntity(new GenericType<List<UsersData>>() {});
        return get;
    }
}
