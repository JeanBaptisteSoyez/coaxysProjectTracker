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

    public static Project getProject(String name) {
        Project project = Project.find("name = ?1", name).first();
        return project;
    }

    public static Project updateProject(String name) {
        Project project = getProject(name);
        project.name = name;
        return project;
    }

    public static void deleteProject(String name) {
        Project project = getProject(name);
        project.delete();
    }

}
