package Dao;

import Entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public class CustomDao<T> {
    EntityManager entityManager;

    public CustomDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    boolean addCustom(T t){
        try{
            entityManager.persist(t);
            return true;
        }catch (PersistenceException px){
            px.printStackTrace();
            return  false;
        }
    }

    public boolean editCustom(T t) {
        try {
            entityManager.merge(t);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean customeDelete(T t){
        try {
            entityManager.merge(t);
            entityManager.remove(t);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}