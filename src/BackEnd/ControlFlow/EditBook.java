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
@WebServlet(urlPatterns = "editBook")
public class EditBook extends CustomServlet{


    @EJB
    BookInterface bookInterface;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd=req.getRequestDispatcher("EditBook.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book=new Book();

        if (get(req,"field").equals("title")){
            book.setTitle(get(req,"changed"));
        }
        else if (get(req,"field").equals("author"))
            book.setAuther(get(req,"changed"));
        else if(get(req,"field").equals("category"))
            book.setBookCategory(get(req,"changed"));
        else if(get(req,"field").equals("publisher"))
            book.setPublisher(get(req,"changed"));

        HttpSession session=req.getSession(false);
        if (session.getAttribute("name") != null) {
            if (bookInterface.edit(book)) {
                PrintWriter out = resp.getWriter();
                out.print("<html><body><p> You have successfully edited the title : <a href=\"editTitle\">Back</a> </p></body></html>");
            } else {
                PrintWriter out = resp.getWriter();
                out.print("<html><body><p> An error occurred please try again : <a href=\"editTitle\">Back</a> </p></body></htm>");
            }
        }
    }
}
