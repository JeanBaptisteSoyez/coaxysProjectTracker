package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by formation04 on 29/03/17.
 */
@Entity
public class Status extends Model {

    @Required
    @Column(nullable = false)
    public String label;
    @Required
    @Column(nullable = false)
    public String remarks;
    @Required
    @Column(nullable = false)
    public Date date;

    @ManyToOne
    public Task task;

    @ManyToOne
    public Sprint sprint;

}
