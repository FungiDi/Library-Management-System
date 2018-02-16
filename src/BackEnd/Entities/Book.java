package Entities;

import javax.persistence.*;



@NamedQueries({
        @NamedQuery(
                name = "SelectAllBooks",
                query = "select b from Book b "
        ),
        @NamedQuery(
                name = "SelectBookById",
                query = "select b from Book b where b.bookReg=:id"
        ),
        @NamedQuery(
                name = "SelectAvailableBooks",
                query = "select b from Book b where b.status=:state"
        ),
        @NamedQuery(
                name = "SelectBorrowedBooks",
                query = "select b from Book b where b.status=:state"
        ),
        @NamedQuery(
                name = "SelectByName",
                query = "select b from Book b where  b.title like lower(:bname) "
        )
})
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bId;
    private String bookReg;
    private String title;
    private String auther;
    private String bookCategory;
    private String publisher;
    private String status;


    public String getBookReg() {
        return bookReg;
    }

    public void setBookReg(String bookReg) {
        this.bookReg = bookReg;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public long getbId() {
        return bId;
    }

    public void setbId(long bId) {
        this.bId = bId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
