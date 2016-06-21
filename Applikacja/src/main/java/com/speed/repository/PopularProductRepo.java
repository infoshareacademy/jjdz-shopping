package com.speed.repository;

import com.speed.model.ReportPopularProducts;
import com.speed.service.ReportDTO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by piotr on 14.05.16.
 */
@Stateless
public class PopularProductRepo {

    @PersistenceContext
    EntityManager em;


    public List<ReportDTO> getPopularProduct() {
        List<ReportDTO> list = em.createQuery("select new com.speed.service.ReportDTO(p.product, count(p)) " +
                "from ReportPopularProducts as p group by p.product order by count(p) desc, p.product asc", ReportDTO.class)
                .getResultList();
        System.out.println(list);
        return list;
    }
}
