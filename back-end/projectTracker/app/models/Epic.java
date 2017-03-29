package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by formation04 on 29/03/17.
 */
@Entity
public class Epic extends Model {

    @Required
    @Column(nullable = false)
    public String name;

    @OneToMany
    public List<Story> stories;

    @ManyToOne
    public Project project;

}
