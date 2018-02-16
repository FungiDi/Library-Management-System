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
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "deleteAdmin")
public class DeleteAdminServlet extends CustomServlet {

    @EJB
    AdminInterface adminInterface;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd=req.getRequestDispatcher("deleteAdmin.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin=new Admin();
        admin.setStaffregNo(get(req,"regNo"));
        Admin a=adminInterface.viewByIdObj(admin);
        if (adminInterface.remove(a)){
            resp.sendRedirect("viewAdmin");
        }
        else {
            PrintWriter out=resp.getWriter();
            out.print("<html><body><p> An error occurred please try again <a href=\"viewAdmin\">Back</a> </p></body></html>");
        }
    }
}
