package services;

import models.Epic;
import models.Project;

import java.util.Date;

/**
 * Created by formation04 on 30/03/17.
 */
public class EpicService {

    public static Epic createEpic(String name, String description, Date date, Project project) {
        Epic epic = new Epic(name, description, date, project);
        epic.save();
        return epic;
    }

    public static Epic getEpicById(long idEpic) {
        return Epic.findById(idEpic);
    }

    public static Epic updateEpic(Epic epic, String name, String description, Date date) {
        epic.name = name;
        epic.description = description;
        epic.date = date;
        epic.save();
        return epic;
    }

    public static void deleteEpic(Epic epic) {
        epic.delete();
    }
}
