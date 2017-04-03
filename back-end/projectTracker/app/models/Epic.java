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
    @JoinColumn(name = "idProject")
    public List<Story> stories;

    @ManyToOne
    public Project project;

    public Epic(String name, List<Story> stories, Project project) {
        this.name = name;
        this.stories = stories;
        this.project = project;
    }

    public Epic(String name, List<Story> stories) {
        this.name = name;
        this.stories = stories;
    }
}
