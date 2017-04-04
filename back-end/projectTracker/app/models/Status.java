package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by formation04 on 29/03/17.
 */
@Entity
public class Status extends Model {

    @Required
    @Column(nullable = false)
    public String label;
    public String action;
    @Required
    @Column(nullable = false)
    public String remarks;
    @Required
    @Column(nullable = false)
    public Timestamp date;

    public String descriptionVersion;
    public String descriptionSprint;

    @ManyToOne
    @JoinColumn(name = "idTask")
    public Task task;

    public Status(String label, String action, String remarks, Timestamp date, String descriptionVersion, String descriptionSprint, Task task) {
        this.label = label;
        this.action = action;
        this.remarks = remarks;
        this.date = date;
        this.descriptionVersion = descriptionVersion;
        this.descriptionSprint = descriptionSprint;
        this.task = task;
    }
}
