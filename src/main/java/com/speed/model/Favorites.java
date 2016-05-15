package com.speed.model;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by raker on 03.05.16.
 */
@Stateless
public class Favorites {

    private List<Category> favorites;

    public Favorites() {this.favorites = new ArrayList<>();}

    public List<Category> getFavorites() {
        return favorites;
    }

    public void addToFavorites(Category category){
        favorites.add(category);
    }

}
