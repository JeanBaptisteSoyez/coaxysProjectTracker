package services;

import models.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public static Status updateStatus(int idStatus, String label, String remarks, Date date, int idTask){
        Status status = getStatusById(idStatus);
        status.label = label;
        status.remarks = remarks;
        status.date = date;
        status.task = TaskService.getTaskById(idTask);
        return status;
    }

    public static void  deleteStatus(int idStatus){
        Status status = getStatusById(idStatus);
        status.delete();
    }
}
