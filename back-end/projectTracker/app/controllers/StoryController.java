package controllers;

import models.Story;
import play.mvc.Controller;

import java.util.List;

/**
 * Created by formation04 on 03/04/17.
 */
public class StoryController extends Controller {

    public static void stories() {
        List<Story> stories = null;
        try {
            stories = Story.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        renderJSON(stories);
    }

    public static void story(Long id) {
        Story story = Story.findById(id);
        renderJSON(story);
    }

}
