package com.speed.service;

import com.speed.model.Category;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by slaw on 15.05.16.
 */

@Entity
@Table (name = "users")
@NamedQuery(name="findByEmail", query = "SELECT u FROM UsersData u WHERE u.userEmail = :email")
public class UsersData implements Serializable{

    public UsersData(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
//        this.id = 1L;
    }

    private String userName;
    private String userEmail;

    @OneToMany
//            (mappedBy = "user")
    private List<Category> favorites = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public UsersData() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "UsersData{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", favorites=" + favorites +
                ", id=" + id +
                '}';
    }

    public List<Category> getFavorites() {
        return favorites;
    }

    public void addCategoryToFavorites(Category category) {
        favorites.add(category);
    }


//    private String id;
//
//    @Id
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
}
