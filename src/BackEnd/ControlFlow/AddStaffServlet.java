package ControlFlow;

import AllInterfaces.AdminInterface;
import Entities.Admin;
import Entities.Staff;
import Enums.Gender;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "AddStaff")
public class AddStaffServlet extends CustomServlet {

    @EJB
    AdminInterface staffInterface;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher rd = req.getRequestDispatcher("addStaff.jsp");
            rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Staff staff=new Staff();
        Admin staff=new Admin();
        staff.setFirstName(get(req,"fname"));
        staff.setLastName(get(req, "lname"));
        staff.setEmail(get(req,"email"));
        staff.setPassword(get(req,"pass"));
        String gender=get(req,"gen");
        if (gender.equals("Male"))
            staff.setGender(Gender.male);
        if(gender.equals("Female"))
            staff.setGender(Gender.female);
       // staff.setStaffType(get(req,"sType"));
        staff.setStaffregNo(get(req,"regNo"));

        HttpSession session=req.getSession(false);
        if (session.getAttribute("name") != null) {
        if(staffInterface.add(staff)){
            resp.sendRedirect("AddStaff");
        }}

    }
}
