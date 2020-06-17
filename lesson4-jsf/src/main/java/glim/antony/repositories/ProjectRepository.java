package glim.antony.repositories;

import glim.antony.model.Project;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class ProjectRepository {

    private List<Project> projects = new ArrayList<>();

    @PostConstruct
    public void init() throws ServletException {
        projects.add(new Project(1L, "Title 1", "Description 1", LocalDate.of(2021, 1, 1)));
        projects.add(new Project(2L, "Title 2", "Description 2", LocalDate.of(2022, 2, 2)));
        projects.add(new Project(3L, "Title 3", "Description 3", LocalDate.of(2023, 3, 3)));
    }

    public List<Project> findAll() {
        return projects;
    }

    public Project findOneById(Long id) {
        return projects
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Project project) {
        projects.add(project);
    }

    public void removeById(Long id) {
        Project project = findOneById(id);
        projects.remove(project);
    }
}
