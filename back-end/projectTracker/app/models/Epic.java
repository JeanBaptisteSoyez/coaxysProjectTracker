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
public class Epic extends Model {

    @Required
    @Column(nullable = false)
    public String name;
    public String description;
    public Date date;

    @ManyToOne
    @JoinColumn(name = "idProject")
    public Project project;

    @OneToMany(mappedBy = "epic")
    public List<Story> stories;


    public Epic(String name, String description, Date date , Project project) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.stories = new ArrayList<>();
        this.project = project;
    }
}
