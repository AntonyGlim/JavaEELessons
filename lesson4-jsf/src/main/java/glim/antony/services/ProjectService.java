package glim.antony.services;

import glim.antony.model.Project;
import glim.antony.repositories.ProjectRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Qualifier;
import java.util.List;

@Named
@ApplicationScoped
public class ProjectService {

    @Inject
    private ProjectRepository projectRepository;

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findOneById(Long id) {
        return projectRepository.findOneById(id);
    }

    public void save(Project project) {
        projectRepository.save(project);
    }

    public void removeById(Long id) {
        projectRepository.removeById(id);
    }
}
