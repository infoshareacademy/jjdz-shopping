
// Zawartość tej klasy to sugestie Kuby odnośnie przebudowania klasy Favorites tak,
// aby ulubione były dopisywane do bazy w tabeli User

package com.speed.model;

import com.speed.service.UserNotAuthorisedExeption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Stateless
public class FavoritesDB {

    @PersistenceContext
    EntityManager em;

    @Inject
    SessionData sessionData;

    private Logger logger = LoggerFactory.getLogger(FavoritesDB.class);

    public Set<Category> getFavorites() throws UserNotAuthorisedExeption {
        Optional<UsersData> usersDataOptional = sessionData.getUser();

        if (!usersDataOptional.isPresent()) {
            throw new UserNotAuthorisedExeption();
        }
        UsersData user = usersDataOptional.get();
        return user.getFavorites();
    }

    @Transactional
    public void addToFavorites(Category category) throws UserNotAuthorisedExeption {
        Optional<UsersData> usersDataOptional = sessionData.getUser();

        if (!usersDataOptional.isPresent()) {
            throw new UserNotAuthorisedExeption();
        }
        UsersData user = usersDataOptional.get();
        category = em.merge(category);
        user.getFavorites().add(category);
    }

    @Transactional
    public void removeFromFavourites (Category category) throws UserNotAuthorisedExeption {
        Optional<UsersData> usersDataOptional = sessionData.getUser();
        if (!usersDataOptional.isPresent()) {
            throw new UserNotAuthorisedExeption();
        }
        UsersData user = usersDataOptional.get();
        user.getFavorites().remove(category);
    }
}

