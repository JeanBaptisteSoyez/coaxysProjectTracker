package services;

import models.Sprint;
import models.Status;
import models.Task;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by formation on 30/03/17.
 */
public class StatusService {



    public static Status createStatus(String label, String action, String remarks, Timestamp date, String descriptionVersion, String descriptionSprint, Task task) {
        Status status = new Status( label, action, remarks, date, descriptionVersion,descriptionSprint,task);
        status.save();
        return status;
    }

    public static Status getStatusById(long idStatus) {
        return Status.findById(idStatus);
    }

    public static Status updateStatus(Status status, String label, String action, String remarks, Timestamp date, String descriptionVersion, String descriptionSprint) {
        status.label = label;
        status.action = action;
        status.remarks = remarks;
        status.date = date;
        status.descriptionVersion = descriptionVersion;
        status.descriptionSprint = descriptionSprint;
        status.save();
        return status;
    }

    public static void deleteStatus(Status status) {
        status.delete();
    }


    /********
     * User *
     ********/


}
