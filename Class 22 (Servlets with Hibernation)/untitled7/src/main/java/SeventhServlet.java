import javax.servlet.*;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SeventhServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("servicing...");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        EmployeeDaoImpl dao = new EmployeeDaoImpl();
        ArrayList<Employee> employees = new ArrayList<>();
        employees = dao.getAllUser();
        String a = dao.getA();
        a += "<script>\n";
        a += "document.getElementById(\"tables\").innerHTML += `\n";
        for (Employee employee : employees) {
            a += "<tr>\n";
            a += "<td>" + employee.getUsername() +"</td>\n";
            a += "<td>" + employee.getPassword() +"</td>\n";
            a += "<td>" + employee.getAge() +"</td>\n";
            a += "<td>" + employee.getGender() +"</td>\n";
            a += "</tr>\n";
        }
        a += "</tr>`;\n";
        a += "</script>\n";
        a += "</body>\n";
        a += "</html>\n";

        out.println(a);
    }

}
