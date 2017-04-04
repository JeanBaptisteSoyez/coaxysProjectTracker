package controllers;

import models.User;
import play.mvc.Controller;

import java.util.List;

/**
 * Created by formation04 on 03/04/17.
 */
public class UserController extends Controller {

    public static void users() {
        List<User> users = null;
        try {
            users = User.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        renderJSON(users);
    }

    public static void user(Long id) {
        User user = User.findById(id);
        renderJSON(user);
    }

}
