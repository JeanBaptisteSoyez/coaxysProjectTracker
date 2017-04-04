package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by formation04 on 29/03/17.
 */
@Entity
public class Task extends Model {

    @Required
    @Column(nullable = false)
    public String name;
    @Required
    @Column(nullable = false)
    public String process;
    @Required
    @Column(nullable = false)
    public String results;
    @Required
    @Column(nullable = false)
    public String parameters;
    public Timestamp date;

    @ManyToOne
    @JoinColumn(name = "idStory")
    public Story story;

    //
//    @OneToMany
//    public List<Status> statuses;

    public Task(String name, String process, String results, String parameters, Timestamp date, Story story) {
        this.name = name;
        this.process = process;
        this.results = results;
        this.parameters = parameters;
        this.date = date;
        this.story = story;
    }
}
