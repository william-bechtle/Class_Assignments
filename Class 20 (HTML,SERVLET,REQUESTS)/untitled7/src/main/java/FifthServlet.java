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
        String url = "0";
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        url = request.getParameter("url");
        System.out.println("name: " + name);
        System.out.println("GET");
        System.out.println("url: " + url);


        Cookie[] cookies = request.getCookies();
        if (Objects.equals(url, "1")) {
            System.out.println("hey");
            eraseit eraseit = new eraseit();
            eraseit.eraseCookie(request,response);
            request.getRequestDispatcher("/block.html").include(request, response);
        }

        else if (!Objects.equals(name, "admin@admin.com") && !Objects.equals(name, "wjb@gmail.com")) {
            String a =
                    """
                    <script> 
                        alert("ERROR.. NO EXISTING USER");
                        location.href = "http://localhost:8081/home";
                    </script>""";
            out.println(a);
        }
        else if (cookies != null) {
            request.getRequestDispatcher("/home2.html").include(request, response);
        }
        else {
            Cookie cookie = new Cookie("email", name);
            response.addCookie(cookie);
            request.getRequestDispatcher("/home2.html").include(request, response);
        }
    }


};
class eraseit {
    public void eraseCookie(HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies) {
                cookie.setValue("");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
    }
}