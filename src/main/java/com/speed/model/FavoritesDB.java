
// Zawartość tej klasy to sugestie Kuby odnośnie przebudowania klasy Favorites tak,
// aby ulubione były dopisywane do bazy w tabeli User

    package com.speed.model;

    import com.speed.service.SessionData;
    import com.speed.service.UsersData;

    import javax.ejb.Stateless;
    import javax.inject.Inject;
    import javax.persistence.*;
    import java.util.ArrayList;
    import java.util.List;

    @Stateless
    public class FavoritesDB {

        @PersistenceContext
        EntityManager em;

        @Inject
        SessionData sessionData;

        public List<Category> getFavorites() {
            UsersData user = sessionData.getUser();
            em.refresh(user);
            return user.getFavorites();
        }

        public void addToFavorites(Category category){
            UsersData user = sessionData.getUser();
            user.setFavorites(category);
            em.merge(user);
        }
    }

