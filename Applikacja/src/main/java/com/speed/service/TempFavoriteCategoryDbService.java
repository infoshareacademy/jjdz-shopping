package com.speed.service;


import com.speed.model.TempFavoriteCategory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TempFavoriteCategoryDbService {

    @PersistenceContext
    EntityManager em;

    public void addTempFavorite(TempFavoriteCategory tempFavoriteCategory){
        em.persist(tempFavoriteCategory);
    }
}
