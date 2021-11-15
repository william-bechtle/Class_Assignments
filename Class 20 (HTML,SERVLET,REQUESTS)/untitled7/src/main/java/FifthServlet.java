import javax.servlet.*;
import javax.servlet.Servlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FifthServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        Cookie[] cookies = request.getCookies();

        if (!Objects.equals(name, "admin@admin.com") && !Objects.equals(pass, "pass")) {
            String a =
                    """
                    <script> 
                        alert("ERROR.. NO EXISTING USER");
                        location.href = "http://localhost:8080/home";
                    </script>""";
            out.println(a);
        }
        else if (cookies != null) {
            request.getRequestDispatcher("/home2.html").include(request, response);
        }
        else {
            Cookie cookie = new Cookie("email", name);
            response.addCookie(cookie);
            Cookie cookie2 = new Cookie("pass", pass);
            response.addCookie(cookie2);
            request.getRequestDispatcher("/home2.html").include(request, response);
        }
    }
}