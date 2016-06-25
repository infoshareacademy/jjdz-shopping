package com.speed.service;

import com.speed.model.SearchEvent;
import com.speed.model.SearchEventEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ReportService {

    @PersistenceContext
    EntityManager em;

    public Long save(SearchEvent event){
        SearchEventEntity entity = new SearchEventEntity(event);
        em.persist(entity);

        return entity.getId();
    }

    public SearchEvent getSearchEventById(Long id){
        return em.find(SearchEventEntity.class, id).getEvent();
    }
}
