package com.speed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by slaw on 15.05.16.
 */

@Entity
@Table (name = "users")
@NamedQuery(name="findByEmail", query = "SELECT u FROM UsersData u WHERE u.userEmail = :email")
public class UsersData implements Serializable{

    @Column(name = "userName")
    private String userName;
    @Column(name = "userEmail")
    private String userEmail;
    @Column(name = "reportFrequency")
    private String reportFrequency;
    @Column(name = "userType")
    private String userType;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//            (mappedBy = "user")
    @JsonIgnore
    private Set<Category> favorites = new HashSet<>();

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public UsersData(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;

    }

    public UsersData(String userName, String userEmail, String reportFrequency, String userType) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.reportFrequency = reportFrequency;
        this.userType = userType;
    }

    public UsersData(String userEmail) {
        this.userEmail = userEmail;
    }


    public UsersData() {
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setReportFrequency(String reportFrequency) {
        this.reportFrequency = reportFrequency;
    }

    public String getReportFrequency() {
        return reportFrequency;
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
                ", reportFrequency=" + reportFrequency +
                ", favorites=" + favorites +
                ", id=" + id +
                '}';
    }

    public Set<Category> getFavorites() {
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
