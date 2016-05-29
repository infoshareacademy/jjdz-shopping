package com.speed.model;

import com.speed.service.UsersData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Collections;

@Stateless
public class UserDataDB {

    private Logger logger = LoggerFactory.getLogger(UserDataDB.class);

    @PersistenceContext
    EntityManager em;

    public UsersData findOrSave(UsersData usersData){

        logger.debug("User to find: {}", usersData);
        Query findUserByEmailQuery = em.createNamedQuery("findByEmail");
        findUserByEmailQuery.setParameter("email", usersData.getUserEmail());
//        findUserByEmailQuery.setParameter("id", 1L);
        logger.debug("User email: {}", usersData.getUserEmail());
        Collection<UsersData> foundUsers = findUserByEmailQuery.getResultList();
        logger.debug("Found user size: {}", foundUsers.size());
//        UsersData foundUsers = em.find(UsersData.class, 1L);
        logger.debug("Found user: {}", foundUsers);

        if(foundUsers.isEmpty()){
            logger.debug("User to persist: {}", usersData);
            em.persist(usersData);
            return usersData;
        }

        return foundUsers.iterator().next();
    }


}
