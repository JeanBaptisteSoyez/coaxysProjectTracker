package services;

import models.Epic;
import models.Project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by formation04 on 30/03/17.
 */
public class ProjectService {

    public static Project createProject(String name) {
        List<Epic> epics = new ArrayList<>();
        Project project = new Project(name, epics);
        project.save();
        return project;
    }

    public static Project getProjectByName(String name) {
        Project project = Project.find("name = ?1", name).first();
        return project;
    }

    public static Project getProjectById(int idProject) {
        Project project = Project.find("idProject = ?1", idProject).first();
        return project;
    }

    public static Project updateProject(int idProject, String newName) {
        Project project = getProjectById(idProject);
        project.name = newName;
        project.save();
        return project;
    }

    public static void deleteProject(int idProject) {
        Project project = getProjectById(idProject);
        project.delete();
    }

}
