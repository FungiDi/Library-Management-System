package ControlFlow;

import AllInterfaces.MemberInterface;
import Entities.Member;
import Enums.Gender;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class EditMemberServlet extends CustomServlet{

    @EJB
    MemberInterface memberInterface;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd=req.getRequestDispatcher("editLibrarian.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member member=new Member();
        HttpSession session=req.getSession(false);
        member.setMemberRegNo(get(req,"regNo"));
        Member l=memberInterface.viewByIdObj(member);

        if (session.getAttribute("name")!=null){
            l.setFirstName(get(req,"fname"));
            l.setLastName(get(req,"lName"));
            l.setEmail(get(req,"em"));
            l.setMembershipType(get(req,"gen"));
            String gender=get(req,"gen");

            //System.out.println("Okay!!!!!");
            if (gender.equals("Male"))
                l.setGender(Gender.male);
            if(gender.equals("Female"))
                l.setGender(Gender.female);
            System.out.println("Okay");
            if(memberInterface.edit(l)){
                resp.sendRedirect("adminViewMember");
            }else{
                PrintWriter out=resp.getWriter();
                out.print("<html><body><p> An error occurred please try again <a href=\"adminViewMember\">Back</a> </p></body></html>");
            }
        }else {
            PrintWriter out=resp.getWriter();
            out.print("<html><body><p> An error occurred please login first <a href=\"index.jsp\">Login</a> </p></body></html>");
        }
    }
}
