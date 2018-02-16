package Dao;

import Entities.Librarian;

import javax.persistence.EntityManager;
import java.util.List;

public class LibrarianDao extends CustomDao<Librarian> {

    public LibrarianDao(EntityManager entityManager) {
        super(entityManager);
    }

    public boolean add(Librarian librarian){
        if(addCustom(librarian))
            return true;
        return false;
    }

    public boolean edit(Librarian librarian) {
        if (editCustom(librarian))
            return true;
        return false;
    }

    public boolean remove(Librarian librarian) {
//        if (customeDelete(librarian))
//            return true;
//        return false;
        try {
            int delete=entityManager.createNamedQuery("deleteLibrarian")
                    .setParameter("id",librarian.getStaffregNo()).executeUpdate();
        if (delete>0)
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }return false;
    }

    public Librarian viewByIdObj(Librarian librarian) {
        try {
            List<Librarian>bookList=entityManager.createNamedQuery("viewLibrarianById")
                    .setParameter("id",librarian.getStaffregNo()).getResultList();
            return bookList.size()>0?bookList.get(0):null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Librarian> viewAll(Librarian librarian) {
        try {
            return entityManager.createNamedQuery("SelectAllLibrarians").getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Librarian> viewById(Librarian librarian) {
        try {
            return entityManager.createNamedQuery("viewLibrarianById")
                    .setParameter("id",librarian.getStaffregNo()).getResultList();
        }catch (Exception e){
            return null;
        }

    }
}
