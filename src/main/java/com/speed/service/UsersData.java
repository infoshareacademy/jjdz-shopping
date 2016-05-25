package com.speed.service;

import com.speed.model.Category;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by slaw on 15.05.16.
 */

@Entity
@Table (name = "users")
public class UsersData implements Serializable{

    public UsersData(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

    private String userName;
    private String userEmail;

    @OneToMany(mappedBy = "user")
    private List<Category> favorites;

    @Id
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
                '}';
    }

    public List<Category> getFavorites() {
        return favorites;
    }

    public void setFavorites(Category category) {
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
