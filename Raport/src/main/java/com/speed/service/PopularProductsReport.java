package com.speed.service;

import com.speed.model.ReportDTO;
import com.speed.model.SearchEvent;
import com.speed.model.SearchEventEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PopularProductsReport {

    @PersistenceContext
    EntityManager em;


    public List<ReportDTO> getPopularProduct() {
        List<ReportDTO> list = em.createQuery("select new com.speed.model.ReportDTO(p.event.product, count(p)) " +
                "from SearchEventEntity as p group by p.event.product order by count(p) desc, p.event.product asc", ReportDTO.class)
                .getResultList();
        System.out.println(list);
        return list;
    }
}
