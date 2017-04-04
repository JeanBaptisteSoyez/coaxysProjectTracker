package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by formation04 on 29/03/17.
 */
@Entity
public class Story extends Model {

    @Required
    @Column(nullable = false)
    public String name;
    public String description;
    public Date date;
    @Required
    @Column(nullable = false)
    public Boolean isActive;

    @OneToMany(mappedBy = "story")
    public List<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "idEpic")
    public Epic epic;



    public Story(String name, String description, Boolean isActive, Date date, Epic epic) {
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.date = date;
        this.epic = epic;
    }

}
