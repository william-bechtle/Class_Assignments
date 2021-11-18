import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.*;
import javax.servlet.Servlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FourthServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("email");
        String pass = request.getParameter("password");
        String gender = request.getParameter("inlineRadioOptions");
        String age = request.getParameter("age");

        // create a configuration object
        Configuration cfg = new Configuration();

        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");

        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();

        // create employee
        Employee employee = new Employee();
        employee.setUsername(name);
        employee.setPassword(pass);
        employee.setGender(gender);
        int age2 = Integer.parseInt(age);
        employee.setAge(age2);

        int a = 0;
        try {
            // save the employee
            session.save(employee);
            // commit the transaction
            t.commit();
            a = 1;
        }
        catch (Exception e){
            System.out.println(e);
        }
        // close the connection
        session.close();


        // create a cookie
        if (a == 1) {
            request.getRequestDispatcher("/register.html").include(request, response);
        }
        else {
            request.getRequestDispatcher("/form2.html").include(request, response);
        }
    }
}
