package controllers;

import models.Epic;
import play.mvc.Controller;

import java.util.List;

/**
 * Created by formation04 on 03/04/17.
 */
public class EpicController extends Controller {

    public static void epics() {
        List<Epic> epics = null;
        /*try {
            epics = EpicService.epics();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        renderJSON(epics);
    }

}
