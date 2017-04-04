package controllers;

import models.Epic;
import play.data.validation.Validation;
import play.mvc.Controller;

import java.util.Date;
import java.util.List;

/**
 * Created by formation04 on 03/04/17.
 */
public class EpicController extends Controller {

    public static void epics() {
        List<Epic> epics = null;
        try {
           epics = Epic.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        renderJSON(epics);
    }

    public static void createEpic(String name, String description, Date date) {
        if (Validation.hasErrors()) {
            params.flash();
            Validation.keep();
        }
        Epic newEpic = new Epic();
        newEpic.name = name;
        newEpic.description = description;
        newEpic.date = new Date();
//        Epic epic = EpicService.createEpic("", "", );
        renderJSON(newEpic);
    }

    public static void epic(Long id) {
        Epic epic = Epic.findById(id);
        renderJSON(epic);
    }

}