package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
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

    public String description;

    public Date date;

    @OneToMany(mappedBy = "project")
    public List<Version> versions;

    @OneToMany(mappedBy = "project")
    public List<Sprint> sprints;

//    @ManyToMany
//    public List<User> users;
//
//    @OneToMany(mappedBy = "project")
//    public List<Epic> epics;
//
//    public Project(String name, List<Epic> epics) {
//        this.name = name;
//        this.epics = epics;
//    }

    public Project(String name, String description, Date date) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.versions = new ArrayList<Version>();
        this.sprints = new ArrayList<Sprint>();
    }
}
