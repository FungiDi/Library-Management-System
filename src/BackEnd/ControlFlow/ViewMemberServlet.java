package ControlFlow;

import AllInterfaces.MemberInterface;
import Entities.Librarian;
import Entities.Member;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "viewMember")
public class ViewMemberServlet extends CustomServlet{


    @EJB
    MemberInterface memberInterface;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member member=new Member();
        List<Member> members=memberInterface.viewAll(member);
        req.setAttribute("mem",members);
            RequestDispatcher rd = req.getRequestDispatcher("viewMember.jsp");
            rd.forward(req, resp);
    }
}
