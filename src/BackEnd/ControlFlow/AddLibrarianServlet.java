package ControlFlow;

import AllInterfaces.CustomPersonInterface;
import AllInterfaces.LibrarianInterface;
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

@WebServlet(urlPatterns = "AddLibrarian")
public class AddLibrarianServlet extends CustomServlet {

    @EJB
    LibrarianInterface librarianInterface;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher rd = req.getRequestDispatcher("AddLibrarian.jsp");
            rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Librarian librarian=new Librarian();
        librarian.setFirstName(get(req,"fname"));
        librarian.setLastName(get(req,"lname"));
        librarian.setEmail(get(req,"email"));
        librarian.setPassword(get(req,"pass"));
        String gender=get(req,"gen");
        if (gender.equals("Male"))
            librarian.setGender(Gender.male);
        if(gender.equals("Female"))
            librarian.setGender(Gender.female);
        librarian.setStaffregNo(get(req,"regNo"));

        HttpSession session=req.getSession(false);
        if (session.getAttribute("name") != null) {
        if (librarianInterface.add(librarian)){
            resp.sendRedirect("AddLibrarianServlet");
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<html><body><p> An error occurred please try again <a href=\"AddLibrarianServlet\">Back</a> </p></body></html>");
        }
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<html><body><p> Please login again <a href=\"index.jsp\">Back</a> </p></body></html>");
        }
    }
}
