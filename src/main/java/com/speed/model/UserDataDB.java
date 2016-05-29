package com.speed.model;

import com.speed.service.UsersData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Stateless
public class UserDataDB {

    @PersistenceContext
    EntityManager em;
    private Logger logger = LoggerFactory.getLogger(UserDataDB.class);

    public UsersData findOrSave(UsersData usersData){

        logger.debug("User to find: {}", usersData);
        TypedQuery<UsersData> findUserByEmailQuery = em.createNamedQuery("findByEmail", UsersData.class);
        findUserByEmailQuery.setParameter("email", usersData.getUserEmail());
//        findUserByEmailQuery.setParameter("id", 1L);
        logger.debug("User email: {}", usersData.getUserEmail());
        List<UsersData> foundUsers = findUserByEmailQuery.getResultList();
        logger.debug("Found user size: {}", foundUsers.size());
//        UsersData foundUsers = em.find(UsersData.class, 1L);
        logger.debug("Found user: {}", foundUsers);

        if(foundUsers.isEmpty()){
            logger.debug("User to persist: {}", usersData);
            return em.merge(usersData);
        }

        return foundUsers.iterator().next();
    }

    public Optional<UsersData> find(UsersData usersData) {

        TypedQuery<UsersData> findUserByEmailQuery = em.createNamedQuery("findByEmail", UsersData.class);
        findUserByEmailQuery.setParameter("email", usersData.getUserEmail());

        List<UsersData> foundUsers = findUserByEmailQuery.getResultList();

        if (foundUsers.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(foundUsers.iterator().next());
    }


}
