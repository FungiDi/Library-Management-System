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

@WebServlet(urlPatterns = "addBook")
public class AddBookServlet extends CustomServlet{

    @EJB
    BookInterface bookInterface;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher rd=req.getRequestDispatcher("addBook.jsp");
            rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book=new Book();

        book.setBookReg(get(req,"regNo"));
        book.setTitle(get(req,"title"));
        book.setAuther(get(req,"auth"));
        book.setBookCategory(get(req,"cat"));
        book.setPublisher(get(req,"pub"));
        book.setStatus("Not issued");

        HttpSession session=req.getSession(false);
        if (session.getAttribute("name") != null) {
            if (bookInterface.add(book)) {
                resp.sendRedirect("viewAllBooks");
            }else {
                PrintWriter out = resp.getWriter();
                out.print("<html><body><p> An error occurred please try again <a href=\"addBook\">Back</a> </p></body></html>");
            }
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<html><body><p> Please login again <a href=\"index.jsp\">Back</a> </p></body></html>");
        }
    }
}
