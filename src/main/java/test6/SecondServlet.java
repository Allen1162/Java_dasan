package test6;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

public class SecondServlet extends HttpServlet {

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServletContext sc = getServletContext();
        Student student = (Student) sc.getAttribute("student");
        String id = student.getSno();
        String name = student.getName();

        out.println("<html>");
        out.println("<body>");
        out.println("<head>");
        out.println("<title>output</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>学生信息：</h2>");
        out.println("<table width=\"500\" border=\"1\">");

        out.println("<tr>");
        out.println("<td width=\"175\">学号</td>");
        out.println("<td width=\"325\">" + id + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>姓名</td>");
        out.println("<td>" + name + "</td>");
        out.println("</tr>");
        out.println("<a href=input.html>");
        out.println("返回登录界面");
        out.println("</a>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

}
