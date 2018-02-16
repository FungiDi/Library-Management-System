package ControlFlow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "logout")
public class LogoutServlet extends CustomServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ses=req.getSession(false);
        if(ses==null) {

            resp.sendRedirect("index.jsp");

        }
        else{
            ses.invalidate();
            resp.sendRedirect("index.jsp");
        }
    }


}
