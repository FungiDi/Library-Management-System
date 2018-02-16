package Dao;

import Entities.Admin;
import Entities.Staff;

import javax.persistence.EntityManager;
import java.util.List;

public class AdminLoginDao {

    EntityManager entityManager;

    public AdminLoginDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean login(Admin admin){
        try {
          List<Admin>adminList= entityManager.createNamedQuery("adminLogin")
                  .setParameter("em",admin.getEmail())
                  .setParameter("pass",admin.getPassword()).getResultList();
          return adminList.size()>0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
