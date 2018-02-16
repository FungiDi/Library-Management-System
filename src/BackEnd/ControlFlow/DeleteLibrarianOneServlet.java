package ControlFlow;

import AllInterfaces.LibrarianInterface;
import Entities.Librarian;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "deleteLibrarianOne")
public class DeleteLibrarianOneServlet extends CustomServlet {

    @EJB
    LibrarianInterface librarianInterface;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Librarian librarian=new Librarian();
        librarian.setStaffregNo(get(req,"staffregNo"));

        List<Librarian> librarianList=librarianInterface.viewById(librarian);
        HttpSession session=req.getSession(false);
        if (session.getAttribute("name")!=null){
        if (librarianList!=null){
            for (Librarian l:librarianList){
               // HttpSession session=req.getSession(false);
                session.setAttribute("libId",l.getStaffregNo());
                session.setAttribute("firstName",l.getFirstName());
                session.setAttribute("lastName",l.getLastName());
                session.setAttribute("liEmail",l.getEmail());
                session.setAttribute("lGender",l.getGender());
            }
            resp.sendRedirect("deleteLibrarian");
        }
        else {
            PrintWriter out = resp.getWriter();
            out.print("<html><body><p> An error occurred please try again <a href=\"adminViewLibrarian\">Back</a> </p></body></html>");
        }
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<html><body><p> Please login again <a href=\"index.jsp\">Back</a> </p></body></html>");
        }
    }
}
