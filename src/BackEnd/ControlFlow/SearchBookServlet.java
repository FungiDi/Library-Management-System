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

@WebServlet(urlPatterns = "viewById")
public class SearchBookServlet extends CustomServlet{

    @EJB
    BookInterface bookInterface;


//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Book book=new Book();
//        List<Book>bookList= bookInterface.viewById(book);
//        req.setAttribute("oneBook",bookList);
//            RequestDispatcher rd = req.getRequestDispatcher("ViewSearched.jsp");
//            rd.forward(req, resp);
//
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book=new Book();
        book.setBookReg(get(req,"search"));
        Book b=bookInterface.viewByIdObj(book);
        //List<Book>bookList=bookInterface.viewById(book);
        //System.out.println(b.getTitle());
        //List<Admin>adminList=adminInterface.viewById(admin);
        HttpSession session=req.getSession(false);
        if (session.getAttribute("name") != null) {
            if (bookInterface.viewById(b) != null) {
               // for (Book b:bookList);
                //System.out.println(b.getTitle());
                resp.sendRedirect("finalSearch");
            } else {
                PrintWriter out = resp.getWriter();
                out.print("<html><body><p> Sorry that Id doesnot exist! : <a href=\"viewById\">Back</a> </p></body></html>");
            }
        }
    }
}
