package ControlFlow;

import AllInterfaces.BookInterface;
import AllInterfaces.MemberInterface;
import Entities.Book;
import Entities.IssueBookActivity;
import Entities.Member;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("borrowBook")
public class BorrowBookServlet extends CustomServlet {

    @EJB
    BookInterface bookInterface;
    @EJB
    MemberInterface memberInterface;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd=req.getRequestDispatcher("borrowBook.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book=new Book();
        Member member=new Member();
        IssueBookActivity issueBookActivity=new IssueBookActivity();
        Date d=new Date();
        book.setBookReg(get(req,"regNo"));
        member.setMemberRegNo(get(req,"mNo"));
        Book b= bookInterface.viewByIdObj(book);
        System.out.println(b);
        Member m=memberInterface.viewByIdObj(member);
        System.out.println(m);
        System.out.println("Okay");

        HttpSession session=req.getSession(false);
        if (session.getAttribute("name") != null) {
            if (b != null && m != null && b.getStatus() != "issued") {
                System.out.println("Okay1");
                b.setStatus("issued");

                issueBookActivity.setIssueDate(String.valueOf(d));
                System.out.println("Okay");
                issueBookActivity.setReturnDate((get(req, "returnDate")));
                issueBookActivity.setBook(b);
                issueBookActivity.setMember(m);
                issueBookActivity.setDetails("issue");
                if (bookInterface.borrow(b, issueBookActivity)) {
                    resp.sendRedirect("viewAllBooks");
                } else {
                    PrintWriter out = resp.getWriter();
                    out.print("<html><body><p> An error occurred please try again <a href=\"borrowBook\">Back</a> </p></body></html>");
                }
            }else {
                PrintWriter out = resp.getWriter();
                out.print("<html><body><p> The book is issued or doesn't exist please try again <a href=\"borrowBook\">Back</a> </p></body></html>");
            }
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<html><body><p> please login first <a href=\"index.jsp\">Back</a> </p></body></html>");
        }
    }
}
