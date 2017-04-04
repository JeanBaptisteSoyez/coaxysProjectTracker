package controllers;

import models.Task;
import play.mvc.Controller;

import java.util.List;

/**
 * Created by formation04 on 03/04/17.
 */
public class TaskController extends Controller {

    public static void tasks() {
        List<Task> tasks = null;
        try {
            tasks = Task.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        renderJSON(tasks);
    }

    public static void task(Long id) {
        Task task = Task.findById(id);
        renderJSON(task);
    }

}
