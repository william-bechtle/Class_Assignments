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

        // create a cookie

        request.getRequestDispatcher("/register.html").include(request, response);
    }
}
