package services;

import models.Sprint;
import models.Status;
import models.Task;

import java.util.Date;

/**
 * Created by formation on 30/03/17.
 */
public class StatusService {

    //String label, String remarks, Date date, Task task, Sprint sprint

    public static Status createStatus(String label, String remarks, Date date, int idTask, int idProject){
        Task task = TaskService.getTaskById(idTask);
        Sprint sprint = SprintService.getActualSprint(idProject);
        Status status = new Status(label,remarks, date, task, sprint);
        status.save();
        return status;
    }

    public static Status getStatusById(int idStatus){
        Status status = Status.find("idStatus = ?1", idStatus).first();
        return status;
    }

    public static Status updateStatus(int idStatus, String newLabel, String newRemarks, Date newDate, int idTask){
        Status status = getStatusById(idStatus);
        status.label = newLabel;
        status.remarks = newRemarks;
        status.date = newDate;
        status.task = TaskService.getTaskById(idTask);
        status.save();
        return status;
    }

    public static void  deleteStatus(int idStatus){
        Status status = getStatusById(idStatus);
        status.delete();
    }
}
