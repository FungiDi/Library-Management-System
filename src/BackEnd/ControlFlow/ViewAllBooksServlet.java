package ControlFlow;

import AllInterfaces.BookInterface;
import Entities.Book;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "viewAllBooks" )
public class ViewAllBooksServlet extends CustomServlet {

    @EJB
    BookInterface bookInterface;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book book=new Book();
        List<Book>bookList=bookInterface.viewAll(book);
        req.setAttribute("allBooks",bookList);
        HttpSession session=req.getSession(false);

            RequestDispatcher rd = req.getRequestDispatcher("viewAllBooks.jsp");
            rd.forward(req, resp);
    }
}
