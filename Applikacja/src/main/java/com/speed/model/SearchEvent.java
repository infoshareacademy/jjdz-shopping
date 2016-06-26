package com.speed.model;



import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Embeddable
public class SearchEvent {

    @NotNull
    @Size(min = 2)
    private String product;
    private LocalDate date;

    public SearchEvent() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "SearchEvent{" +
                "product='" + product + '\'' +
                ", date=" + date +
                '}';
    }
}
