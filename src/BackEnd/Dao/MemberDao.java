package Dao;

import Entities.Member;

import javax.persistence.EntityManager;
import java.util.List;

public class MemberDao extends CustomDao<Member> {


    public MemberDao(EntityManager entityManager) {
        super(entityManager);
    }

    public boolean add(Member member){
        if(addCustom(member))
            return true;
        return false;
    }

    public Member viewByIdObj(Member member) {

        try {
            List<Member>bookList=entityManager.createNamedQuery("viewById")
                    .setParameter("regNo",member.getMemberRegNo()).getResultList();
            return bookList.size()>0?bookList.get(0):null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Member> viewById(Member member) {
        try {
            return entityManager.createNamedQuery("viewById")
                    .setParameter("regNo",member.getMemberRegNo()).getResultList();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Member> viewAll(Member member){
        try {
            return entityManager.createNamedQuery("viewAll").getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
