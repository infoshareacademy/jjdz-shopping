package com.speed.kosz;

import com.speed.model.Category;
import com.speed.model.Favorites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by piotr on 14.05.16.
 */
public class ReportDTO {

    private String product;
    private Long count;

    public ReportDTO(String product, Long count) {
        this.product = product;
        this.count = count;
    }

    public String getProduct() {
        return product;
    }

    public Long getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
                "product='" + product + '\'' +
                ", count=" + count +
                '}';
    }

}

