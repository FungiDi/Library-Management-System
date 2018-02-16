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
import java.util.List;

@WebServlet(urlPatterns = "editLibrarianTwo")
public class editLibrarianTwoServlet extends CustomServlet{

    @EJB
    LibrarianInterface librarianInterface;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Librarian librarian=new Librarian();
        librarian.setStaffregNo(get(req,"staffregNo"));

        List<Librarian>librarianList=librarianInterface.viewById(librarian);
        if (librarianList!=null){
            for (Librarian l:librarianList){
                HttpSession session=req.getSession(false);
                session.setAttribute("libId",l.getStaffregNo());
                session.setAttribute("liFirstName",l.getFirstName());
                session.setAttribute("liLastName",l.getLastName());
                session.setAttribute("liEmail",l.getEmail());
                session.setAttribute("lGender",l.getGender());
            }
            resp.sendRedirect("editLibrarian");
        }

    }
}
