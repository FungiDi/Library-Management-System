package ControlFlow;

import AllInterfaces.Authenticate;
import Entities.Member;
import Qualifiers.LoginQualifier;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "memberLogin")
public class MemberLoginServlet extends CustomServlet{

    @Inject
    @LoginQualifier(value = LoginQualifier.LoginChoice.member)
    Authenticate<Member> authenticate;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd=req.getRequestDispatcher("welcomeMember.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Member member=new Member();
        member.setEmail(get(req,"email"));
        member.setPassword(get(req,"pass"));

        if (authenticate.login(member)){
            HttpSession session =req.getSession();
            session.setAttribute("name",get(req,("email")));
            resp.sendRedirect("memberLogin");
        }else{
            HttpSession sess=req.getSession(true);
            sess.setAttribute("errorMessage","Username and password do not match\n" +
                    " Please enter valid cridentials");
            resp.sendRedirect("index.jsp");
        }
    }
}
