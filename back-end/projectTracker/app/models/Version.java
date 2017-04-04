package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by formation on 03/04/17.
 */
@Entity
public class Version extends Model {
    public Date startDate;
    public Date endDate;
    public String description;
    public int number;

    @ManyToOne
    @JoinColumn(name = "idProject")
    public Project project;

    public Version(Date startDate, Date endDate, String description, int number, Project project) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.number = number;
        this.project = project;
    }
}
