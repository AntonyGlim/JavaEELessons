package glim.antony.controllers;

import glim.antony.model.Project;
import glim.antony.services.ProjectService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProjectController implements Serializable {

    private static final long serialVersionUID = 6970967365515828010L;

    @Inject
    private ProjectService projectService;

    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String createNewProject() {
        this.project = new Project();
        return "edit-project.xhtml?faces-redirect=true";
    }

    public List<Project> findAll() {
        return projectService.findAll();
    }

    public String updateProject(Project project) {
        this.project = project;
        return "edit-project.xhtml?faces-redirect=true";
    }

    public String deleteProject(Project project) {
        projectService.removeById(project.getId());
        return "projects.xhtml?faces-redirect=true";
    }

    public String save(Project project) {
        projectService.save(project);
        return "projects.xhtml?faces-redirect=true";
    }
}
