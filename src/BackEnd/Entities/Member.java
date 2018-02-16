package Entities;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "memberLogin",
                query = "select email,password from Member where email=:em and password=:pass"
        ),
        @NamedQuery(
                name = "viewById",
                query = "select m from Member m where m.memberRegNo=:regNo"
        ),
        @NamedQuery(
                name = "viewAll",
                query = "select m from Member m"
        )
})

public class Member extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mId;
    private String membershipType;
    private String memberRegNo;

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getMemberRegNo() {
        return memberRegNo;
    }

    public void setMemberRegNo(String memberRegNo) {
        this.memberRegNo = memberRegNo;
    }
}
