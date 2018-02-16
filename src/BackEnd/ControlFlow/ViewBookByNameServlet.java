package ControlFlow;

import AllInterfaces.BookInterface;
import Entities.Book;

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

@WebServlet(urlPatterns = "ViewByName")
public class ViewBookByNameServlet extends CustomServlet {
    @EJB
    BookInterface bookInterface;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd=req.getRequestDispatcher("welcomeLibrarian.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book();
        book.setTitle("search");
        List<Book> bookList = bookInterface.viewByName(book);
        HttpSession session = req.getSession(false);
        if (session.getAttribute("name") != null) {
            if (bookList != null) {
                req.setAttribute("books", bookList);
                resp.sendRedirect("ViewBookByName.jsp");
            } else {
                resp.sendRedirect("ViewByName");
            }
        } else {
            PrintWriter out = resp.getWriter();
            out.print("<html><body><p> An error occurred please login first <a href=\"index.jsp\">Login</a> </p></body></html>");
        }
    }
}
