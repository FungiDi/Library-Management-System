package ControlFlow;

import AllInterfaces.BookInterface;
import Entities.Book;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/finalSearch")
public class FinalSearchServlet extends CustomServlet {

    @EJB
    BookInterface bookInterface;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book=new Book();
        List<Book> bookList= bookInterface.viewById(book);
        req.setAttribute("oneBook",bookList);
        RequestDispatcher rd = req.getRequestDispatcher("ViewSearched.jsp");
        rd.forward(req, resp);

    }


}
