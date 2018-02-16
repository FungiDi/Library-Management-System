package Dao;

import Entities.Admin;

import javax.persistence.EntityManager;
import java.util.List;

public class AdminDao extends CustomDao<Admin>{

    public AdminDao(EntityManager entityManager) {
        super(entityManager);
    }

    public boolean add(Admin admin){
        if (addCustom(admin))
            return true;
        return false;
    }

    public boolean editAdmin(Admin admin){
        if (editCustom(admin))
            return true;
        return false;
    }

    public Admin viewByIdObj(Admin admin) {
        try {
            List<Admin> adminList=entityManager.createNamedQuery("SelectById")
                    .setParameter("id",admin.getStaffregNo()).getResultList();
            return adminList.size()>0?adminList.get(0):null;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public  List<Admin> viewById(Admin admin) {
        try {
            return entityManager.createNamedQuery("SelectById")
                    .setParameter("id",admin.getStaffregNo()).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean delete(Admin admin){
        try {
            int delete=entityManager.createNamedQuery("deleteAdmin")
                    .setParameter("id",admin.getStaffregNo()).executeUpdate();
            if (delete>0)
                return true;
        }catch (Exception e){
            return false;
        }
        return false;
    }

    public List<Admin> viewAll(Admin admin) {
        try {
            return entityManager.createNamedQuery("SelectAll").getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    }
