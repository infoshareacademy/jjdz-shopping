package com.speed.controller;

import com.speed.model.UserDataDB;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Stateless
@Path("/application")
public class ApplicationController {

    @Inject
    UserDataDB userDataDB;

    @GET
    @Path("/usersEmails")
    @Produces("application/json")
    public List<String> getUsers(){
        return userDataDB.getUsersEmails();
    }
}
