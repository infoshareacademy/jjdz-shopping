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

//    public void updateUserReportSchedule(String userScheduleParam, String userEmail){


//        UsersData user= em.find(UsersData.class, 1L);
//
//        Query query = em.createQuery("update UsersData u set u.reportFrequency = :userScheduleParam where u.userEmail = :userEmail");
//        query.setParameter("userScheduleParam", userScheduleParam);
//        query.setParameter("userEmail", userEmail);
//        query.executeUpdate();
//    }

    public List<UsersData> allUsersData() {

        List<UsersData> allUsers = em.createQuery("select new com.speed.model.UsersData(u.userName, u.userEmail, u.reportFrequency, u.userType)" +
                "from UsersData as u", UsersData.class)
                .getResultList();
        System.out.println("allUsers: " + allUsers);
        return  allUsers;
    }
}
