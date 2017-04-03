package services;

import models.Epic;
import models.Story;
import models.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by formation on 30/03/17.
 */
public class StoryService {


//    public static Story createStory(String name, Boolean isActive, int idEpic){
//        List<Task> tasks = new ArrayList<>();
//        Epic epic = EpicService.getEpicById(idEpic);
//        Story story = new Story(name, isActive, tasks, epic);
//        story.save();
//        return story;
//    }
//
//    public static Story getStoryById(int idStory){
//        Story story = Story.find("idStory = ?1", idStory).first();
//        return story;
//    }
//
//    public static Story updateStory(int idStory, String newName, Boolean newActive){
//        Story story = getStoryById(idStory);
//        story.name = newName;
//        story.isActive = newActive;
//        story.save();
//        return story;
//    }
//
//    public static void deleteStory(int idStory){
//        Story story = getStoryById(idStory);
//        story.delete();
//    }
}
