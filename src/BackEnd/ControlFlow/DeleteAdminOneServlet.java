package ControlFlow;

import AllInterfaces.AdminInterface;
import Entities.Admin;
import Entities.Librarian;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "deleteAdminOne")
public class DeleteAdminOneServlet extends CustomServlet {

    @EJB
    AdminInterface adminInterface;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin=new Admin();
        admin.setStaffregNo(get(req,"staffregNo"));

        List<Admin>adminList=adminInterface.viewById(admin);

        HttpSession session=req.getSession(false);
        if (session.getAttribute("name")!=null){
        if (adminList!=null){
            for (Admin a:adminList){
                //HttpSession session=req.getSession(false);
                session.setAttribute("aId",a.getStaffregNo());
                session.setAttribute("firstName",a.getFirstName());
                session.setAttribute("lastName",a.getLastName());
                session.setAttribute("aEmail",a.getEmail());
                session.setAttribute("aGender",a.getGender());
            }resp.sendRedirect("deleteAdmin");
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<html><body><p> An error occurred please try again <a href=\"deleteAdmin\">Back</a> </p></body></html>");
        }
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<html><body><p> Please login again <a href=\"index.jsp\">Back</a> </p></body></html>");
        }
    }
}
