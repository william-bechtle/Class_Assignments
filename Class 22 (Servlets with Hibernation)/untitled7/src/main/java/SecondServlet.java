import javax.servlet.*;
import javax.servlet.Servlet;
import java.io.IOException;
import java.io.PrintWriter;

public class SecondServlet extends GenericServlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servicing...");
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        servletRequest.getRequestDispatcher("/block.html").include(servletRequest, servletResponse);
        out.close();

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
