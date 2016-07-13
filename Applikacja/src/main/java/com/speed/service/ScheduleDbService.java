package com.speed.service;

import com.speed.model.UsersData;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ScheduleDbService {

    @PersistenceContext
    EntityManager em;

    public void updateUserReportSchedule(String userScheduleParam, String userEmail){
        UsersData user= em.find(UsersData.class , 1);
        em.createQuery("update UsersData set reportFrequency = :userScheduleParam where userEmail = :userEmail")
                .executeUpdate();

//        em.createQuery("update UsersData p set p.reportFrequency = userScheduleParam WHERE p.userEmail= :userEmail");
//        System.out.println(userScheduleParam);
    }
}
