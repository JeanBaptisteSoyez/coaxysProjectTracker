package services;

import models.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by formation on 30/03/17.
 */
public class TaskService {

    public static Task createTask(String name, String process, String results, String parameters, Timestamp date, Story story) {
        Task task = new Task(name, process, results, parameters, date, story);
        task.save();
        return task;
    }

    public static Task getTaskById(long idTask) {
        return Task.findById(idTask);
    }

    public static Task updateTask(Task task, String name, String process, String results, String parameters, Timestamp date) {
        task.name = name;
        task.process = process;
        task.results = results;
        task.parameters = parameters;
        task.date = date;
        task.save();
        return task;
    }

    public static void deleteTask(Task task) {
        task.delete();
    }
}
