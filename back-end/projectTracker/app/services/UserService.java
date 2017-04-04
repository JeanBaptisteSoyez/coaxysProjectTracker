package services;

import models.Project;
import models.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by formation on 30/03/17.
 */
public class UserService {

    public static User createUser(String nom, String role, String email, String password, Date date) {
        User user =new User(nom, role, email, password, date);
        user.save();
        return user;
    }

    public static User getUserById(long idUser) {
        return User.findById(idUser);
    }

    public static User updateUser(User user, String name, String role, String email, String password, Date date) {
        user.name = name;
        user.role = role;
        user.email = email;
        user.password = password;
        user.date = date;
        user.save();
        return user;
    }

    public static void deleteUser(User user) {
        user.delete();
    }
}
