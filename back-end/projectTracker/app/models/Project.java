package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by formation04 on 29/03/17.
 */
@Entity
public class Project extends Model {

    @Required
    @Column(nullable = false)
    public String name;

    @OneToMany
    public List<Epic> epics;

    public Project(String name, List<Epic> epics) {
        this.name = name;
        this.epics = epics;
    }

}
