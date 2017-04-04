package controllers;

import models.Project;
import play.mvc.Controller;

import java.util.List;

/**
 * Created by formation04 on 03/04/17.
 */
public class ProjectController extends Controller {

    public static void projects() {
        List<Project> projects = null;
        try {
            projects = Project.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        renderJSON(projects);
    }

    public static void project(Long id) {
        Project project = Project.findById(id);
        renderJSON(project);
    }

}
