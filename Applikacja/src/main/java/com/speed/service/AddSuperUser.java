package com.speed.service;

import com.speed.model.UserDataDB;
import com.speed.model.UsersData;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Startup
@Singleton
public class AddSuperUser {
    @EJB
    UserDataDB userDataDB;

    public AddSuperUser() {
    }

    @PostConstruct
    public void addSuperUser() {
        userDataDB.addAdmin();

        System.out.println("SUPER USER ADDED");
    }
}
