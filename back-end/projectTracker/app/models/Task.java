package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
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

    @OneToMany
    public List<Status> statuses;

    @ManyToOne
    public Story story;

}
