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
    @Required
    @Column(nullable = false)
    public Date startEnd;

    @OneToMany
    public List<Status> statuses;

}
