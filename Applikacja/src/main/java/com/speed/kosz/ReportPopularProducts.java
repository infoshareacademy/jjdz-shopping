package com.speed.kosz;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Stateless
@Entity
@Table(name = "ReportPopularProducts")
public class ReportPopularProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "product")
    private String product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }


}
