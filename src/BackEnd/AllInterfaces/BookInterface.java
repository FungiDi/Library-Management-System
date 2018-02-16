package AllInterfaces;

import Entities.Book;
import Entities.IssueBookActivity;
import Entities.Member;

import javax.ejb.Local;
import java.util.List;

@Local
public interface BookInterface {

    boolean add(Book book);

    boolean remove(Book book);

    boolean edit(Book book);

    List <Book> viewById(Book book);
    List<Book> viewByName(Book book);
    Book viewByIdObj(Book book);

    List <Book> viewAll(Book book);

    boolean borrow(Book book, IssueBookActivity activity);

    boolean returnBook(Book book, IssueBookActivity activity);

    List<Book> viewBorrowedBooks(Book book);

    List<Book> availableBooks(Book book);

    boolean reserve(Book book, IssueBookActivity activity);
}
