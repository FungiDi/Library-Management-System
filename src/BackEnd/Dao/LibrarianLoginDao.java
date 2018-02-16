package Dao;

import Entities.Librarian;

import javax.persistence.EntityManager;
import java.util.List;

public class LibrarianLoginDao {

    EntityManager entityManager;

    public LibrarianLoginDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean login(Librarian librarian){
        try {
            List<Librarian>librarians=entityManager.createNamedQuery("librarianLogin")
                    .setParameter("em",librarian.getEmail())
                    .setParameter("pass",librarian.getPassword()).getResultList();
            return librarians.size()>0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
