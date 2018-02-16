package ControlFlow;

import AllInterfaces.AdminInterface;
import Entities.Admin;
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

@WebServlet(urlPatterns = "editAdmin")
public class EditAdminServlet extends CustomServlet {

    @EJB
    AdminInterface adminInterface;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher rd = req.getRequestDispatcher("EditAdmin.jsp");
            rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin=new Admin();
        HttpSession session=req.getSession(false);
        admin.setStaffregNo(get(req,"regNo"));
        Admin a=adminInterface.viewByIdObj(admin);

        if (session.getAttribute("name")!=null){
            a.setFirstName(get(req,"fname"));
            a.setLastName(get(req,"lName"));
            a.setEmail(get(req,"em"));
            String gender=get(req,"gen");

            System.out.println("Okay!!!!!");
            if (gender.equals("Male"))
                a.setGender(Gender.male);
            if(gender.equals("Female"))
                a.setGender(Gender.female);
            System.out.println("Okay");
            if(adminInterface.edit(a)){
                resp.sendRedirect("viewAdmin");
            }else{
                PrintWriter out=resp.getWriter();
                out.print("<html><body><p> An error occurred please try again <a href=\"viewAdmin\">Back</a> </p></body></html>");
            }
        }else {
            PrintWriter out=resp.getWriter();
            out.print("<html><body><p> An error occurred please login first <a href=\"index.jsp\">Login</a> </p></body></html>");
        }
    }
}
