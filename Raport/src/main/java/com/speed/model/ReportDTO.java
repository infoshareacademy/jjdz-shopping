package com.speed.model;

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
        return "PopularProduktInfo{" +
                "product='" + product + '\'' +
                ", count=" + count +
                '}';
    }

}

