package ControlFlow;

import AllInterfaces.Authenticate;
import Entities.Librarian;
import Entities.Staff;
import Qualifiers.LoginQualifier;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "librarianLogin")
public class LibrarianLoginServlet extends CustomServlet {


   @Inject
   @LoginQualifier(value = LoginQualifier.LoginChoice.librarian)
   private Authenticate<Librarian> authenticate;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Librarian staff=new Librarian();
        staff.setEmail(get(req,"email"));
        staff.setPassword(get(req,"pass"));

        if (authenticate.login(staff)){
            HttpSession session =req.getSession();
            session.setAttribute("name",get(req,("email")));
            resp.sendRedirect("librarianHome");
        }else{
            HttpSession sess=req.getSession(true);
            sess.setAttribute("errorMessage","Username and password do not match\n" +
                    " Please enter valid cridentials");
            resp.sendRedirect("librarianLogin");
        }
    }
}
