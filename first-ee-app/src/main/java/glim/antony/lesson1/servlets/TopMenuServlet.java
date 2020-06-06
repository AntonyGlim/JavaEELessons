package glim.antony.lesson1.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TopMenuServlet", urlPatterns = "/topmenu")
public class TopMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String activeEndpointName = (String) req.getAttribute("activeEndpointName");
        req.getRequestURL();

        String rootPath = "http://" +  req.getServerName() + ":" + req.getServerPort() + req.getContextPath(); //http://127.0.0.1:8080/first-ee-app/main
//        String rootPath = "/" + req.getContextPath() + "/main";

        resp.getWriter().println("<div>");
        resp.getWriter().printf("<a %s href=\"%s/main\">Main</a>", activeEndpointName.equals("/main") ? "class=\"active\"" : "", rootPath);
        resp.getWriter().printf("<a %s href=\"%s/catalog\">Catalog</a>", activeEndpointName.equals("/catalog") ? "class=\"active\"" : "", rootPath);
        resp.getWriter().printf("<a %s href=\"%s/product\">Product</a>", activeEndpointName.equals("/product") ? "class=\"active\"" : "", rootPath);
        resp.getWriter().printf("<a %s href=\"%s/cart\">Cart</a>", activeEndpointName.equals("/cart") ? "class=\"active\"" : "", rootPath);
        resp.getWriter().printf("<a %s href=\"%s/order\">Order</a>", activeEndpointName.equals("/order") ? "class=\"active\"" : "", rootPath);
        resp.getWriter().println("</div>");
    }
}
