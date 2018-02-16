package Beans;

import AllInterfaces.CustomPersonInterface;
import AllInterfaces.LibrarianInterface;
import Dao.LibrarianDao;
import Entities.Librarian;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class LibrarianBean implements LibrarianInterface{

    @PersistenceContext
    EntityManager entityManager;


    public boolean add(Librarian librarian) {
        LibrarianDao librarianDao=new LibrarianDao(entityManager);
        if (librarianDao.add(librarian))
            return true;
        return false;
    }

    public boolean remove(Librarian librarian) {
        LibrarianDao librarianDao=new LibrarianDao(entityManager);
        if (librarianDao.remove(librarian))
            return true;
        return false;
    }

    public boolean edit(Librarian librarian) {
        LibrarianDao librarianDao=new LibrarianDao(entityManager);
        if (librarianDao.edit(librarian))
            return true;
        return false;
    }

    public Librarian viewByIdObj(Librarian librarian) {
        LibrarianDao librarianDao=new LibrarianDao(entityManager);
        if (librarianDao.viewByIdObj(librarian)!=null)
            return librarianDao.viewByIdObj(librarian);
        return null;
    }

    public List<Librarian> viewById(Librarian librarian) {
        LibrarianDao librarianDao=new LibrarianDao(entityManager);
        if (librarianDao.viewById(librarian)!=null)
            return librarianDao.viewById(librarian);
        return null;
    }

    public List<Librarian> viewAll(Librarian librarian) {
        LibrarianDao dao=new LibrarianDao(entityManager);
        if (dao.viewAll(librarian)!=null)
            return dao.viewAll(librarian);
        return null;
    }
}
