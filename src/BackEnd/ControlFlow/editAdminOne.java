package ControlFlow;

import AllInterfaces.AdminInterface;
import Entities.Admin;
import Entities.Librarian;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "editAdminOne")
public class editAdminOne extends CustomServlet {

    @EJB
    AdminInterface adminInterface;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin=new Admin();
        admin.setStaffregNo(get(req,"staffregNo"));

        List<Admin> adminList=adminInterface.viewById(admin);
        if (adminList!=null){
            for (Admin a:adminList){
                HttpSession session=req.getSession(false);
                session.setAttribute("aId",a.getStaffregNo());
                session.setAttribute("firstName",a.getFirstName());
                session.setAttribute("lastName",a.getLastName());
                session.setAttribute("email",a.getEmail());
                session.setAttribute("gender",a.getGender());
            }
            resp.sendRedirect("editAdmin");
        }

    }
}
