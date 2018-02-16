package Entities;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "librarianLogin",
                query = "select email,password from Librarian where email=:em and password=:pass"
        ),

        @NamedQuery(
                name = "SelectAllLibrarians",
                query = "select l from Librarian l"
        ),
        @NamedQuery(
                name="viewLibrarianById",
                query = "select l from Librarian l where l.staffregNo=:id"
        ),
        @NamedQuery(
                name = "deleteLibrarian",
                query = "delete from Librarian l where l.staffregNo=:id"
        )
})

public class Librarian extends Staff{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sId;

    public long getsId() {
        return sId;
    }

    public void setsId(long sId) {
        this.sId = sId;
    }
}
