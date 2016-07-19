package com.speed.service;


import com.speed.model.TempFavoriteCategory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class TempFavoriteCategoryDbService {

    @PersistenceContext
    EntityManager em;

    public void addTempFavorite(TempFavoriteCategory tempFavoriteCategory){
        em.persist(tempFavoriteCategory);
    }

    // odpytuje bazę czy jest jakiś tymczasowy wpis
    public List<TempFavoriteCategory> getTempFavoriteCategory() {

        Query query = em.createQuery("select u from TempFavoriteCategory as u");
        List<TempFavoriteCategory> list = (List<TempFavoriteCategory>) query.getResultList();
        return list;
    }

    // usuwa zawartość tabeli tymczasowych ulubionych
    public void cleanTempFavoriteDB() {
        Query query = em.createQuery("delete from TempFavoriteCategory t");
        query.executeUpdate();
    }
}
