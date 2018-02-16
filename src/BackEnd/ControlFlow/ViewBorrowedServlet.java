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
import java.util.List;

@WebServlet(urlPatterns = "borrowedBooks")
public class ViewBorrowedServlet extends CustomServlet {

    @EJB
    BookInterface bookInterface;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book=new Book();
        book.setStatus("issued");
        List<Book>list= bookInterface.viewBorrowedBooks(book);
        req.setAttribute("borrow",list);
            RequestDispatcher rd = req.getRequestDispatcher("viewBorrowed.jsp");
            rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Book book=new Book();
//        book.setStatus("issued");
//        if (bookInterface.viewBorrowedBooks(book)!=null){
//            resp.sendRedirect("viewBorrowed.jsp");
//        }
    }
}
