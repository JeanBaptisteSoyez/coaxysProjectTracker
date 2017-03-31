package services;

import models.Project;
import models.User;
import play.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by formation on 30/03/17.
 */
public class UserService extends Controller {

    public static User createUser(String name, String role, String mail, String password){
        List<Project> projects = new ArrayList<>();
        User user = new User(name, role, mail, password, projects);
        user.save();
        return user;
    }

    public static User getUserByMail(String mail){
        User user = User.find("mail = ?1", mail).first();
        return user;
    }

    public static User updateUser(String name, String role, String mail, String password, String newMail){
        if(getUserByMail(newMail) != null){
            return null;
        }
        User user = getUserByMail(mail);
        user.name = name;
        user.role = role;
        user.password = password;
        user.mail = newMail;
        return user;
    }

    public static void deleteUser(String mail){
        User user = getUserByMail(mail);
        user.delete();
    }


}
