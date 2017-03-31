package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 * Created by formation04 on 29/03/17.
 */
@Entity
public class Sprint extends Model {

    @Required
    @Column(nullable = false)
    public int number;
    @Required
    @Column(nullable = false)
    public Date startDate;
    public Date endDate;

    @OneToMany
    public List<Status> statuses;

    public Sprint(){
        //TO DO
    }

    public Sprint(int number, Date startDate, Date endDate, List<Status> statuses) {
        this.number = number;
        this.startDate = startDate;
        this.endDate = endDate;
        this.statuses = statuses;
    }

}
