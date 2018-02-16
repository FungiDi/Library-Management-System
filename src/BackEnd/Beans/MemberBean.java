package Beans;

import AllInterfaces.CustomPersonInterface;
import AllInterfaces.MemberInterface;
import Dao.MemberDao;
import Entities.Member;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class MemberBean implements MemberInterface {

    @PersistenceContext
    EntityManager em;
    public boolean add(Member member) {
        MemberDao memberDao=new MemberDao(em);
        if (memberDao.add(member))
            return true;
        return false;
    }

    public boolean remove(Member member) {
        return false;
    }

    public boolean edit(Member member) {
        return false;
    }

    public Member viewByIdObj(Member member) {
        MemberDao memberDao=new MemberDao(em);
        if (memberDao.viewByIdObj(member)!=null)
            return memberDao.viewByIdObj(member);
        return null;
    }

    public  List<Member> viewById(Member member) {
        MemberDao dao=new MemberDao(em);
        if(dao.viewById(member)!=null)
            return dao.viewById(member);
        return null;
    }

    public List<Member> viewAll(Member member) {
        MemberDao dao=new MemberDao(em);
        if (dao.viewAll(member)!=null)
            return dao.viewAll(member);
        return null;
    }
}
