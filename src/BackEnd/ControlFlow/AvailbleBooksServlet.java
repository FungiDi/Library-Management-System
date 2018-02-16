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
@WebServlet(urlPatterns = "availableBooks")
public class AvailbleBooksServlet extends CustomServlet{


    @EJB
    BookInterface bookInterface;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book=new Book();
        book.setStatus("Not issued");
        List<Book> list= bookInterface.availableBooks(book);
        if(list!=null){

            req.setAttribute("available",list);
            RequestDispatcher rd = req.getRequestDispatcher("availableBooks.jsp");
            rd.forward(req, resp);
        }else {
            PrintWriter out=resp.getWriter();
            out.print("<html><body><p> An error occurred please try again <a href=\"memberLogin\">Back</a> </p></body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
