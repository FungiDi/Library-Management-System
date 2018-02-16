package Dao;

import Entities.Book;
import Entities.IssueBookActivity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;


public class BookDao extends CustomDao<Book>{

    public BookDao(EntityManager entityManager) {
        super(entityManager);
    }

    public boolean add(Book book){
        if (addCustom(book))
            return  this.addCustom(book);
        return false;
    }

    public boolean edit(Book book) {
        if (editCustom(book))
            return this.editCustom(book);
        return false;
    }

    public List<Book> viewById(Book book){
        try {
            return entityManager.createNamedQuery("SelectBookById")
                    .setParameter("id",book.getBookReg()).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @SuppressWarnings("unchecked")
    public List<Book> viewByName(Book book){
        try {
            return entityManager.createNamedQuery("SelectByName")
                    .setParameter("bname","%"+book.getTitle()+"%").getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    public Book viewByIdObj(Book book) {

        try {
            List<Book>bookList=entityManager.createNamedQuery("SelectBookById")
                    .setParameter("id",book.getBookReg()).getResultList();
            return bookList.size()>0?bookList.get(0):null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Book> viewAll(Book book) {
        List<Book>list=new ArrayList<Book>();
        try {
            return entityManager.createNamedQuery("SelectAllBooks").getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Book> viewBorrowedBooks(Book book){
        List<Book> list=new ArrayList<Book>();
        try {
            return entityManager.createNamedQuery("SelectBorrowedBooks").setParameter
                    ("state",book.getStatus()).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Book> availableBooks(Book book){
        List<Book>list=new ArrayList<Book>();
        try {
            return entityManager.createNamedQuery("SelectAvailableBooks").setParameter
                    ("state",book.getStatus()).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean borrow(Book book, IssueBookActivity activity) {
        if (viewById(book)!=null){
            try {
                entityManager.merge(book);
                entityManager.persist(activity);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
    public boolean returnBook(Book book, IssueBookActivity activity) {
        if (viewById(book)!=null){
            try{
                entityManager.merge(book);
                entityManager.persist(activity);
                return true;
            }catch (PersistenceException e){
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean reserve(Book book,IssueBookActivity activity) {
        return false;
    }

}
