package Beans;

import AllInterfaces.BookInterface;
import Dao.BookDao;
import Entities.Book;
import Entities.IssueBookActivity;
import Entities.Member;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Local
@Stateless
public class BookBean implements BookInterface {
    @PersistenceContext
    EntityManager em;

    public boolean add(Book book) {

        BookDao bookDao=new BookDao(em);
        if (bookDao.add(book))
            return bookDao.add(book);
        return false;
    }

    public boolean remove(Book book) {
        return false;
    }

    public boolean edit(Book book) {
        return false;
    }

    public List <Book> viewById(Book book) {
        BookDao bookDao=new BookDao(em);
     return  bookDao.viewById(book);
    }

    public List<Book> viewByName(Book book) {
        BookDao bookDao=new BookDao(em);
        return bookDao.viewByName(book);
    }

    public Book viewByIdObj(Book book) {
        BookDao bookDao=new BookDao(em);
        if (bookDao.viewByIdObj(book)!=null)
            return bookDao.viewByIdObj(book);
        return null;
    }

    public List<Book> viewAll(Book book) {
        BookDao bookDao=new BookDao(em);
        if (bookDao.viewAll(book)!=null)
            return bookDao.viewAll(book);
        return null;
    }

    public boolean borrow(Book book, IssueBookActivity activity) {
        BookDao bookDao=new BookDao(em);
        if (bookDao.borrow(book, activity))
            return true;
        return false;
    }

    public boolean returnBook(Book book, IssueBookActivity activity) {
        BookDao bookDao=new BookDao(em);
        if (bookDao.returnBook(book, activity))
            return true;
        return false;
    }

    public List<Book> viewBorrowedBooks(Book book) {
        BookDao bookDao=new BookDao(em);
        if(bookDao.viewBorrowedBooks(book)!=null){
            return bookDao.viewBorrowedBooks(book);
        }return null;
    }

    public List<Book> availableBooks(Book book) {
        BookDao bookDao=new BookDao(em);
        if (bookDao.availableBooks(book)!=null)
            return bookDao.availableBooks(book);
        return null;
    }


    public boolean reserve(Book book, IssueBookActivity activity) {
        return false;
    }
}
