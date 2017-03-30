package models;

import play.data.validation.Email;
import play.data.validation.Password;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by formation04 on 29/03/17.
 */
@Entity
public class User extends Model {

    @Required
    @Column (nullable = false)
    public String name;
    @Required
    @Column (nullable = false)
    public String role;
    @Required
    @Email
    @Column (nullable = false)
    public String mail;
    @Required
    @Password
    @Column (nullable = false)
    public String password;

    @ManyToMany
    public List<Project> projects;

    public User(String name, String role, String mail, String password, List<Project> projects) {
        this.name = name;
        this.role = role;
        this.mail = mail;
        this.password = password;
        this.projects = projects;
    }
    
}
