package Dao;

import Entities.Member;

import javax.persistence.EntityManager;
import java.util.List;

public class MemberLoginDao {
    EntityManager entityManager;

    public MemberLoginDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean login(Member member){
        try {
            List<Member>memberList=entityManager.createNamedQuery("memberLogin")
                    .setParameter("em", member.getEmail())
                    .setParameter("pass",member.getPassword()).getResultList();
            return memberList.size()>0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
