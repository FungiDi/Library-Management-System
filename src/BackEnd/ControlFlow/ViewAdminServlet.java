package ControlFlow;

import AllInterfaces.AdminInterface;
import Entities.Admin;
import Entities.Member;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "viewAdmin")
public class ViewAdminServlet extends CustomServlet {

    @EJB
    AdminInterface adminInterface;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin=new Admin();
        List<Admin> admins=adminInterface.viewAll(admin);
        req.setAttribute("ad",admins);
            RequestDispatcher rd = req.getRequestDispatcher("viewAdmins.jsp");
            rd.forward(req, resp);
    }
}
