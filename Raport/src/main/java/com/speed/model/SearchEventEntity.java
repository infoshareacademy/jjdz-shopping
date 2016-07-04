package com.speed.model;

import javax.persistence.*;

@Entity
public class SearchEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private SearchEvent event;

    public SearchEventEntity() {}

    public SearchEventEntity(SearchEvent event) {
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SearchEvent getEvent() {
        return event;
    }

    public void setEvent(SearchEvent event) {
        this.event = event;
    }
}
