//package ControlFlow;
//
//import AllInterfaces.AdminInterface;
//import Entities.Admin;
//import Entities.Librarian;
//
//import javax.ejb.EJB;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//public class AdminDeleteServlet extends CustomServlet{
//
//    @EJB
//    AdminInterface adminInterface;
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher rd=req.getRequestDispatcher("deleteAdmin.jsp");
//        rd.forward(req,resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Admin admin=new Admin();
//        HttpSession session=req.getSession(false);
//        admin.setStaffregNo(get(req,"regNo"));
//        Admin a=adminInterface.viewByIdObj(admin);
//        if (session.getAttribute("name")!=null){
//            if (adminInterface.remove(a)){
//                resp.sendRedirect("");
//            }
//            else{
//                PrintWriter out=resp.getWriter();
//                out.print("<html><body><p> An error occurred please try again <a href=\"adminViewLibrarian\">Back</a> </p></body></html>");
//            }
//        }else {
//            PrintWriter out=resp.getWriter();
//            out.print("<html><body><p> An error occurred please login first <a href=\"index.jsp\">Login</a> </p></body></html>");
//        }
//    }
//}
