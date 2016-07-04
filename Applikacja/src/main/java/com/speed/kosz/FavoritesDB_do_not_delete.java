package com.speed.kosz;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.*;
import java.util.List;


// Zawartość tej klasy to sugestie Kuby odnośnie przebudowania klasy Favorites tak,
// aby ulubione były dopisywane do bazy w tabeli User


public class FavoritesDB_do_not_delete {

//    package com.speed.model;
//
//    import javax.ejb.Stateless;
//    import javax.inject.Inject;
//    import javax.persistence.*;
//    import java.util.ArrayList;
//    import java.util.List;
//
//    /**
//     * Created by raker on 03.05.16.
//     */
//    @Stateless
//    public class Favorites {
//
//        @PersistenceContext
//        EntityManager em;
//
//        @Inject
//        SessionData sessionData;
//
//        public List<Category> getFavorites() {
//            User user = sessionData.getUser();
//            em.refresh(user);
//            return user.getFav();
//        }
//
//        public void addToFavorites(Category category){
////        User user = em.find(User.class, sessionData.getUserInfo());
////        user.addFav(category);
////        em.persist(user);
//
//            User user = sessionData.getUser();
//            user.addFav(category);
//            em.merge(user);
//        }
//
//        @Entity
//        public static class User {
//
//            private String username;
//
//            @OneToMany
//            private List<Category> favourites;
//
//            @Id
//            private Long id;
//
//            public Long getId() {
//                return id;
//            }
//
//            public void setId(Long id) {
//                this.id = id;
//            }
//
//
//        }
//    }



}
