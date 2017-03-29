package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Created by formation04 on 29/03/17.
 */
@Entity
public class StatusWatch extends Model {

    @Required
    @ManyToOne
    public Task task;
    @Required
    @ManyToOne
    public Status status;
    @Required
    @OneToOne
    public Sprint sprint;

    @Required
    @Column(nullable = false)
    public Action action;
    @Required
    @Column(nullable = false)
    public Date date;

}
