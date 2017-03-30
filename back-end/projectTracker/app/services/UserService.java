package services;

import models.Project;
import models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by formation on 30/03/17.
 */
public class UserService {

    public User createUser(String name, String role, String mail, String password){
        List<Project> projects = new ArrayList<>();
        User user = new User(name, role, mail, password, projects);
        user.save();
        return user;
    }

    public User getUser(String mail){
        User user = User.find("mail = ?1", mail).first();
        return user;
    }

    public User updateUser(String name, String role, String mail, String password, String newMail){
        if(getUser(newMail) != null){
            return null;
        }
        User user = getUser(mail);
        user.name = name;
        user.role = role;
        user.password = password;
        user.mail = newMail;
        return user;
    }

    public void deleteUser(String mail){
        User user = getUser(mail);
        user.delete();
    }


}
