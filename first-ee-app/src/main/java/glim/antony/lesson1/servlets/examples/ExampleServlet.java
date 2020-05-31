package glim.antony.lesson1.servlets.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class ExampleServlet implements Servlet {

    private static Logger log = LoggerFactory.getLogger(ExampleServlet.class);
    private transient ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        log.info("servlet {} init(...)", getServletInfo());
    }

    @Override
    public ServletConfig getServletConfig() {
        log.info("servlet {} getServletConfig()", getServletInfo());
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        log.info("servlet {} service(...)", getServletInfo());
        servletResponse.getWriter().println(String.format("<h1>Hello from %s!</h1>", getServletInfo()));
    }

    @Override
    public String getServletInfo() {
        return this.getClass().getName();
    }

    @Override
    public void destroy() {
        log.info("servlet {} destroy()", getServletInfo());
    }

}
