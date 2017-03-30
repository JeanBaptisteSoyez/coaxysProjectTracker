package services;

import models.Epic;
import models.Story;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by formation04 on 30/03/17.
 */
public class EpicService {

    public static Epic createEpic(String name) {
        List<Story> stories = new ArrayList<>();
        Epic epic = new Epic(name, stories);
        epic.save();
        return epic;
    }

    public static Epic getEpic(String name) {
        Epic epic = Epic.find("name = ?1", name).first();
        return epic;
    }

    public static Epic updateEpic(String name) {
        Epic epic = getEpic(name);
        epic.name = name;
        return epic;
    }

    public static void deleteEpic(String name) {
        Epic epic = getEpic(name);
        epic.delete();
    }

}
