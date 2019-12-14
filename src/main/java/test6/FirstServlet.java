package test6;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = (String)getServletContext().getAttribute("id");
//        String name = (String)getServletContext().getAttribute("name");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
//        System.out.println(id);
////        System.out.println(name);
        Student student = new Student(id,name);
        getServletContext().setAttribute("student",student);
        getServletContext().getRequestDispatcher("/secondServlet.do").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
