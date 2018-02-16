package ControlFlow;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class CustomServlet extends HttpServlet {
    public String get(HttpServletRequest req, String key){
        return req.getParameter(key);
    }
}
