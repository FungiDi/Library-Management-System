package ControlFlow;

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
import java.util.List;

@WebServlet(urlPatterns = "editLibrarian")
public class EditLibrarianServlet extends CustomServlet{

    @EJB
    LibrarianInterface librarianInterface;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd=req.getRequestDispatcher("editLibrarian.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Librarian librarian=new Librarian();
        HttpSession session=req.getSession(false);
        librarian.setStaffregNo(get(req,"regNo"));
        Librarian l=librarianInterface.viewByIdObj(librarian);

        if (session.getAttribute("name")!=null){
            System.out.println("Okay!!!!1");
           l.setFirstName(get(req,"fname"));
           l.setLastName(get(req,"lName"));
           l.setEmail(get(req,"em"));
            String gender=get(req,"gen");

            System.out.println("Okay!!!!!");
            if (gender.equals("Male"))
                l.setGender(Gender.male);
            if(gender.equals("Female"))
                l.setGender(Gender.female);
            System.out.println("Okay");
                if(librarianInterface.edit(l)){
                resp.sendRedirect("adminViewLibrarian");
                }else{
                    PrintWriter out=resp.getWriter();
                    out.print("<html><body><p> An error occurred please try again <a href=\"adminViewLibrarian\">Back</a> </p></body></html>");
                }
        }else {
            PrintWriter out=resp.getWriter();
            out.print("<html><body><p> An error occurred please login first <a href=\"index.jsp\">Login</a> </p></body></html>");
        }
    }
}
