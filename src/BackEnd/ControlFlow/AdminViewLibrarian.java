package ControlFlow;

import AllInterfaces.LibrarianInterface;
import Entities.Librarian;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "adminViewLibrarian")
public class AdminViewLibrarian extends CustomServlet{

    @EJB
    LibrarianInterface librarianInterface;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Librarian librarian=new Librarian();
        List<Librarian> librarians=librarianInterface.viewAll(librarian);
        req.setAttribute("lib",librarians);
            RequestDispatcher rd=req.getRequestDispatcher("adminViewLibrarians.jsp");
            rd.forward(req,resp);
    }



}
