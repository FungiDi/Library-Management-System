package ControlFlow;

import AllInterfaces.Authenticate;
import Entities.Admin;
import Entities.Staff;
import Qualifiers.LoginQualifier;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "adminLogin")
public class AdminLoginServlet extends CustomServlet {

   @Inject
   @LoginQualifier(value = LoginQualifier.LoginChoice.admin)
   private Authenticate<Admin> authenticate;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd=req.getRequestDispatcher("adminLogin.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin=new Admin();
        admin.setEmail(get(req,"email"));
        admin.setPassword(get(req,"pass"));

        if (authenticate.login(admin)){
            HttpSession session =req.getSession();
            session.setAttribute("name",get(req,("email")));
            resp.sendRedirect("welcomeAdmin");
        }else {
            HttpSession sess=req.getSession(true);
            sess.setAttribute("errorMessage","Username and password do not match\n" +
                    " Please enter valid cridentials");
        }

    }
}
