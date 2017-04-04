package services;

import models.Project;
import models.Sprint;
import models.Version;

import java.util.Date;

/**
 * Created by formation on 30/03/17.
 */
public class SprintService {


    public static Sprint createSprint(String description, int number, Date startDate, Date endDate, Project project) {
        Sprint sprint = new Sprint(startDate, endDate, description, number, project);
        sprint.save();
        return sprint;
    }

    public static Sprint getSprintById(long idSprint) {
        Sprint sprint = Sprint.findById(idSprint);
        return sprint;
    }

    public static Sprint updateSprint(Sprint sprint, String description, int number, Date startDate, Date endDate) {
        sprint.description = description;
        sprint.number = number;
        sprint.startDate = startDate;
        sprint.endDate = endDate;
        sprint.save();
        return sprint;
    }

    public static void deleteSprint(Sprint sprint) {
        sprint.delete();
    }
}
