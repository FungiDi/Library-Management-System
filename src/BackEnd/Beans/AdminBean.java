package Beans;

import AllInterfaces.AdminInterface;
import AllInterfaces.CustomPersonInterface;
import Dao.AdminDao;
import Entities.Admin;
import Entities.Staff;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Local
@Stateless
public class AdminBean implements AdminInterface {

    @PersistenceContext
    EntityManager em;
    public boolean add(Admin admin) {
        AdminDao staffDao=new AdminDao(em);
        if (staffDao.add(admin))
            return true;
        return false;
    }

    public boolean remove(Admin admin) {
        AdminDao adminDao=new AdminDao(em);
        if (adminDao.delete(admin))
            return true;
        return false;
    }

    public boolean edit(Admin admin) {
        AdminDao adminDao=new AdminDao(em);
        if (adminDao.editAdmin(admin))
            return true;
        return false;
    }

    public Admin viewByIdObj(Admin admin) {
        AdminDao staffDao=new AdminDao(em);
        if (staffDao.viewByIdObj(admin)!=null)
            return staffDao.viewByIdObj(admin);
        return null;
    }

    public  List<Admin> viewById(Admin admin) {
        AdminDao adminDao=new AdminDao(em);
        if (adminDao.viewById(admin)!=null)
            return adminDao.viewById(admin);
        return null;
    }

    public List<Admin> viewAll(Admin admin) {
        AdminDao adminDao=new AdminDao(em);
        if (adminDao.viewAll(admin)!=null)
            return adminDao.viewAll(admin);
        return null;
    }
}
