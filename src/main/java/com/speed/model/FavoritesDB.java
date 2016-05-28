
// Zawartość tej klasy to sugestie Kuby odnośnie przebudowania klasy Favorites tak,
// aby ulubione były dopisywane do bazy w tabeli User

package com.speed.model;

import com.speed.service.SessionData;
import com.speed.service.UsersData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.*;
import java.util.List;

@Stateless
public class FavoritesDB {

    @PersistenceContext
    EntityManager em;

    @Inject
    SessionData sessionData;
    private Logger logger = LoggerFactory.getLogger(FavoritesDB.class);

    public List<Category> getFavorites() {
        UsersData user = sessionData.getUser();
        logger.debug("User in getFavorites: {}", user);
//        em.refresh(user);
        return user.getFavorites();
    }

    public void addToFavorites(Category category){
        logger.debug("Add cat to favorites: {}", category );
        UsersData user = sessionData.getUser();
        logger.debug("User: {}", user);
//        category.setUser(user);
        em.persist(category);
        user.addCategoryToFavorites(category);
        logger.debug("User before merge: {}", user);
        em.merge(user);
    }
}

