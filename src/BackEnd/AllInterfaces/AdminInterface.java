package AllInterfaces;

import Entities.Admin;
import Entities.Book;
import Entities.Staff;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AdminInterface {
    boolean add(Admin admin);

    boolean remove(Admin admin);

    boolean edit(Admin admin);

    Admin viewByIdObj (Admin admin);

    List<Admin> viewById(Admin admin);

    List<Admin> viewAll(Admin admin);
}
