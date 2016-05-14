package com.speed.dao;

import com.speed.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by piotr on 02.05.2016.
 */
public interface Dao<T> {


    public void  create(T object);
    public void upade(T object);
    public List<T> list();
    public T getById(int catId);
    public void remove(int catId);



}


