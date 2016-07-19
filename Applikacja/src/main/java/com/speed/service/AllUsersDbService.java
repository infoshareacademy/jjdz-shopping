package com.speed.service;

import com.speed.model.UsersData;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class AllUsersDbService {

    @PersistenceContext
    EntityManager em;

    public List<UsersData> allUsersData() {

        List<UsersData> allUsers = em.createQuery("select new com.speed.model.UsersData(u.userName, u.userEmail, u.reportFrequency, u.userType)" +
                "from UsersData as u", UsersData.class)
                .getResultList();
        System.out.println("allUsers: " + allUsers);
        return  allUsers;
    }

    public List<UsersData> userTypeByEmail(String userEmail){
//        UsersData user= em.find(UsersData.class, 1L);

        Query query = em.createQuery("select u from UsersData as u where u.userEmail = :userEmail");
        query.setParameter("userEmail", userEmail);
        List<UsersData> userType = (List<UsersData>) query.getResultList();
        return userType;
    }
}
