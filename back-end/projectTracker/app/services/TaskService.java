package services;

import models.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by formation on 30/03/17.
 */
public class TaskService {

//    public static Task createTask(String name, String process, String results, String parameters, int idStory){
//        List<Status> statuses = new ArrayList<>();
//        Story story = StoryService.getStoryById(idStory);
//        Task task = new Task(name, process, results, parameters, statuses, story);
//        task.save();
//        return task;
//    }
//
//    public static Task getTaskById(int idTask){
//        Task task = Task.find("idTask = ?1", idTask).first();
//        return task;
//    }
//
//    public static Task updateTask(int idTask, String newName, String newProcess, String newResults, String newParameters){
//        Task task = getTaskById(idTask);
//        task.name = newName;
//        task.process = newProcess;
//        task.results = newResults;
//        task.parameters = newParameters;
//        task.save();
//        return task;
//    }
//
//    public static void deleteTask(int idTask){
//        Task task = getTaskById(idTask);
//        task.delete();
//    }
}
