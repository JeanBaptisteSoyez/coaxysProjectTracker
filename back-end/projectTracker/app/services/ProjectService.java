package services;

import models.Epic;
import models.Project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by formation04 on 30/03/17.
 */
public class ProjectService {

    public static Project createProject(String name, String description, Date date) {
        List<Epic> epics = new ArrayList<>();
        Project project = new Project(name, description, date);
        project.save();
        return project;
    }

    public static Project getProjectByName(String name) {
        Project project = Project.find("name = ?1", name).first();
        return project;
    }

    public static Project getProjectById(long idProject) {
        Project project = Project.find("id = ?1", idProject).first();
        return project;
    }

    public static void deleteProject(long idProject) {
        Project project = getProjectById(idProject);
        project.delete();
    }

    public static Project updateProject(String oldName, String newName, String desccription, Date date) {
        Project project = getProjectByName(oldName);
        project.name = newName;
        project.description = desccription;
        project.date = date;
        project.save();
        return project;
    }
}
