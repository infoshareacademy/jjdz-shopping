package com.speed.model;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Stateless
@Entity
public class ReportPopularProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String product;
    private int counter;
    @ElementCollection
    private Map<String, Integer> popularProducts;

    public ReportPopularProducts() {
        this.popularProducts = new HashMap<String, Integer>();
    }

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

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Map<String, Integer> getPopularProducts() {

        return popularProducts;
    }

    public void setPopularProducts(Map<String, Integer> popularProducts) {
        this.popularProducts = popularProducts;
    }

    public void addProductToPopularProducts(String product) {

        Integer count = popularProducts.get(product);
        if (count == null) {
            popularProducts.put(product, 1);
        } else {
            popularProducts.put(product, count++);
        }
    }

    public String showPopularProducts(){
        String result = "";
        for(Map.Entry<String, Integer> entry : popularProducts.entrySet()){
            result += "Product : " + entry.getKey() + ", " +  entry.getValue() + "\n";
        }
        return result;
    }
}
