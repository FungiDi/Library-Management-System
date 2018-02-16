package ControlFlow;

import AllInterfaces.AdminInterface;
import AllInterfaces.CustomPersonInterface;
import Entities.Admin;
import Entities.Librarian;
import Enums.Gender;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "addAdmin")
public class AddAdminServlet extends CustomServlet {

    @EJB
    AdminInterface adminInterface;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(false);
            RequestDispatcher rd=req.getRequestDispatcher("addAdmin.jsp");
            rd.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("name") != null) {
            Admin admin = new Admin();
            admin.setFirstName(get(req, "fname"));
            admin.setLastName(get(req, "lname"));
            admin.setEmail(get(req, "email"));
            admin.setPassword(get(req, "pass"));
            String gender = get(req, "gen");
            if (gender.equals("Male"))
                admin.setGender(Gender.male);
            if (gender.equals("Female"))
                admin.setGender(Gender.female);
            admin.setStaffregNo(get(req, "regNo"));

            if (adminInterface.add(admin)) {
                resp.sendRedirect("addAdmin");

            }else {
                PrintWriter out = resp.getWriter();
                out.print("<html><body><p> An error occurred please try again <a href=\"addAdmin\">Back</a> </p></body></html>");
            }
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<html><body><p> Please login again <a href=\"index.jsp\">Back</a> </p></body></html>");
        }
    }
}
