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
public class Sprint extends Model {

    public Date startDate;
    public Date endDate;
    public String description;
    public int number;

    @ManyToOne
    @JoinColumn(name = "idProject")
    public Project project;

    public Sprint(Date startDate, Date endDate, String description, int number, Project project) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.number = number;
        this.project = project;
    }
}
