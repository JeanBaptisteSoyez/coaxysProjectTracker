package controllers;

import models.Sprint;
import play.mvc.Controller;

import java.util.List;

/**
 * Created by formation04 on 03/04/17.
 */
public class SprintController extends Controller {

    public static void sprints() {
        List<Sprint> sprints = null;
        try {
            sprints = Sprint.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        renderJSON(sprints);
    }

    public static void sprint(Long id) {
        Sprint sprint = Sprint.findById(id);
        renderJSON(sprint);
    }

}
