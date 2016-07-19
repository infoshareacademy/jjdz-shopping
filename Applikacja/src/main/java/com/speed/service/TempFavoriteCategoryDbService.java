package com.speed.service;


import com.speed.model.TempFavoriteCategory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TempFavoriteCategoryDbService {

    @PersistenceContext
    EntityManager em;

    public void addTempFavorite(TempFavoriteCategory tempFavoriteCategory){
        em.persist(tempFavoriteCategory);
    }

    //TODO odpytać bazę czy jest jakiś tymczasowy wpis
    public List<TempFavoriteCategory> getTempFavoriteCategory() {

        List<TempFavoriteCategory> list = null;
        return list;
    }
}
