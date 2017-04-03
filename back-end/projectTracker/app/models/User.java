package models;

import play.data.validation.Email;
import play.data.validation.Password;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by formation04 on 29/03/17.
 */
@Entity(name = "User")
@Table(name="User")
public class User extends Model {

//    @Id
//    @GeneratedValue
//    public Integer id;

    @Required
    @Column (nullable = false)
    public String name;
    @Required
    @Column (nullable = false)
    public String role;
    @Required
    @Email
    @Column (nullable = false)
    public String email;
    @Required
    @Password
    @Column (nullable = false)
    public String password;

    @ManyToMany(mappedBy = "users")
    public List<Project> projects;

    public User(String name, String role, String email, String password, List<Project> projects) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.password = password;
        this.projects = projects;
    }

    public User(String name, String role, String email, String password) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.password = password;
    }

}
