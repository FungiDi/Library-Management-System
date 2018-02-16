package Entities;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "adminLogin",
                query = "select email,password from Admin where email=:em and password=:pass "
        ),
        @NamedQuery(
                name = "SelectById",
                query = "select a from Admin a where a.staffregNo=:id"
        ),
        @NamedQuery(
                name = "deleteAdmin",
                query = "delete from Admin a where a.staffregNo=:id"
        ),
        @NamedQuery(
                name = "SelectAll",
                query = "select a from Admin a"
        )
})
public class Admin extends Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long aId;

    public long getaId() {
        return aId;
    }

    public void setaId(long aId) {
        this.aId = aId;
    }
}
