package Dao;

import Entities.IssueBookActivity;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

public class IssueBookActivityDao {

    EntityManager entityManager;

    public IssueBookActivityDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean add(IssueBookActivity activity){
        try {
            entityManager.persist(activity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;

        }
    }
}
