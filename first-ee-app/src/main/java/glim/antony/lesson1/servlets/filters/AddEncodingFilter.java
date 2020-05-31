package glim.antony.lesson1.servlets.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AddEncodingFilter", urlPatterns = "/*")
public class AddEncodingFilter implements Filter {

    private transient FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
        HttpServletResponse httpRsp = (HttpServletResponse) servletResponse;
        httpRsp.setCharacterEncoding("UTF-8");
        httpReq.setAttribute("activeEndpointName", httpReq.getServletPath());
        filterConfig.getServletContext().getRequestDispatcher("/topmenu").include(httpReq, httpRsp);
        filterChain.doFilter(servletRequest, servletResponse);
        httpRsp.getWriter().println("<!--  filter -->");
    }

    @Override
    public void destroy() {

    }
}
