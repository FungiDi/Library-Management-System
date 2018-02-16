package ControlFlow;

import AllInterfaces.CustomPersonInterface;
import AllInterfaces.MemberInterface;
import Entities.Admin;
import Entities.Librarian;
import Entities.Member;
import Enums.Gender;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "addMember")
public class AddMemberServlet extends CustomServlet{

    @EJB
    MemberInterface memberInterface;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher rd = req.getRequestDispatcher("addMember.jsp");
            rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member member = new Member();
        member.setFirstName(get(req, "fname"));
        member.setLastName(get(req, "lname"));
        member.setEmail(get(req, "email"));
        member.setPassword(get(req, "pass"));
        String gender = get(req, "gen");
        if (gender.equals("Male"))
            member.setGender(Gender.male);
        if (gender.equals("Female"))
            member.setGender(Gender.female);
        member.setMemberRegNo(get(req, "regNo"));
        member.setMembershipType(get(req, "type"));

        HttpSession session=req.getSession(false);
        if (session.getAttribute("name") != null) {
        if (memberInterface.add(member)){
            resp.sendRedirect("addMember");
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<html><body><p> An error occurred please try again <a href=\"addMember\">Back</a> </p></body></html>");
        }
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<html><body><p> Please login again <a href=\"index.jsp\">Back</a> </p></body></html>");
        }
    }
}
