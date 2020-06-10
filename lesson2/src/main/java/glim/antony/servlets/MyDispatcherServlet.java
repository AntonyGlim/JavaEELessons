package glim.antony.servlets;

import glim.antony.model.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MyDispatcherServlet", urlPatterns = {"", "/"})
public class MyDispatcherServlet extends HttpServlet {

    private List<Project> projects = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        projects.add(new Project("Title 1", "Description 1", LocalDate.of(2020, 6, 1)));
        projects.add(new Project("Title 2", "Description 2", LocalDate.of(2020, 6, 2)));
        projects.add(new Project("Title 3", "Description 3", LocalDate.of(2020, 6, 3)));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getServletPath()) {
            case "/":
            case "/index":
                getServletContext().getRequestDispatcher("/WEB-INF/templates/jsp/index.jsp").forward(req, resp);
                break;
            case "/projects":
                req.setAttribute("projects", projects);
                getServletContext().getRequestDispatcher("/WEB-INF/templates/jsp/projects.jsp").forward(req, resp);
                break;
            case "/profile":
                getServletContext().getRequestDispatcher("/WEB-INF/templates/jsp/profile.jsp").forward(req, resp);
                break;
            case "/contacts":
                getServletContext().getRequestDispatcher("/WEB-INF/templates/jsp/contacts.jsp").forward(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
