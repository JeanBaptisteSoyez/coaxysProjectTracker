package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by formation04 on 29/03/17.
 */
@Entity
public class Project extends Model {

//    @Id
//    @GeneratedValue
//    public Integer idProject;

    @Required
    @Column(nullable = false)
    public String name;

    @ManyToMany
    public List<User> users;

    @OneToMany(mappedBy = "project")
    public List<Epic> epics;

    public Project(String name, List<Epic> epics) {
        this.name = name;
        this.epics = epics;
    }

}
