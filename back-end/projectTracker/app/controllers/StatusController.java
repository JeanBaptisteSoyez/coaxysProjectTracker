package controllers;

import models.Status;
import play.mvc.Controller;

import java.util.List;

/**
 * Created by formation04 on 03/04/17.
 */
public class StatusController extends Controller {

    public static void status() {
        List<Status> statuses = null;
        try {
            statuses = Status.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        renderJSON(statuses);
    }

    public static void status(Long id) {
        Status status = Status.findById(id);
        renderJSON(status);
    }

}
