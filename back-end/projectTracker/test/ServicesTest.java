import models.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import play.test.Fixtures;
import play.test.UnitTest;
import services.*;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by formation on 03/04/17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServicesTest extends UnitTest {

    @Test
    public  void AAAinitDB(){
        Fixtures.deleteDatabase();
    }


    /***********
     * PROJECT *
     ***********/

    @Test
    public void AAcreateAndRetrieveProject() {
        // Create a new project and save it
        ProjectService.createProject("Mettre théo sur orbite", "On va avoir besoin d'une fusée", new Date());

        // Retrieve the user with it name
        Project mtso = Project.find("byName", "Mettre théo sur orbite").first();

        // Test
        assertNotNull(mtso);
        assertEquals("Mettre théo sur orbite", mtso.name);
    }


    @Test
    public void ABupdateProject(){
        // retrieve the project by its old name
        Project mtso = ProjectService.getProjectByName("Mettre théo sur orbite");

        //modifies the project
        Date date = new Date();
        ProjectService.updateProject("Mettre théo sur orbite", "newName", "description" , date);

        // Test
        assertNotNull(mtso);
        assertEquals("newName", mtso.name);
        assertEquals("description", mtso.description);
        assertEquals(date, mtso.date);
    }

    @Test
    public void ACdeleteProject(){
        // retrieve the project by its name
        Project mtso = ProjectService.getProjectByName("newName");

        // delete the project
        ProjectService.deleteProject(mtso.id);

        // Test
        assertNull(ProjectService.getProjectById(mtso.id));
    }


    /***********
     * VERSION *
     ***********/

    @Test
    public void BAcreateAndRetrieveVersion() {
        // Create a new Version on a project and save it
        Project mtso = ProjectService.createProject("Aplanir le sujet", "On va avoir besoin d'un rouleau", new Date());
        long idVersion = VersionService.createVersion("version une", 1, new Date(), new Date(), mtso.id).id;

        // Retrieve the user with it id
        Version version = VersionService.getVersionById(idVersion);

        // Test
        assertNotNull(version);
        assertEquals("version une", version.description);
    }


    @Test
    public void BBupdateVersion(){
        // retrieve the version of a given project
        Project project = ProjectService.getProjectByName("Aplanir le sujet");
        Version version = Version.find("idProject = ?1", project.id).first();


        //modifies the Version
        Date date = new Date();
        VersionService.updateVersion(version, "description", 2, date, date);

        // Test
        assertNotNull(version);
        assertEquals(2, version.number);
        assertEquals("description", version.description);
        assertEquals(date, version.startDate);
        assertEquals(date, version.endDate);
    }


    @Test
    public void BCdeleteVersion(){
        // retrieve the version of a given project
        Project project = ProjectService.getProjectByName("Aplanir le sujet");
        Version version = Version.find("idProject = ?1", project.id).first();

        // delete the version
        long idVersion = version.id;
        VersionService.deleteVersion(version);

        // Test
        assertNull(VersionService.getVersionById(idVersion));
    }


    /**********
     * Sprint *
     **********/

    @Test
    public void CAcreateAndRetrieveSprint() {
        // Create a new Sprint on a project and save it
        Project mtso = ProjectService.createProject("sprinter le sujet", "On va avoir besoin d'un scrum master", new Date());
        long idSprint = SprintService.createSprint("version une", 1, new Date(), new Date(), mtso).id;

        // Retrieve the user with it id
        Sprint sprint = SprintService.getSprintById(idSprint);

        // Test
        assertNotNull(sprint);
        assertEquals("version une", sprint.description);
    }


    @Test
    public void CBupdateSprint(){
        // retrieve the sprint of a given project
        Project project = ProjectService.getProjectByName("sprinter le sujet");
        Sprint sprint = Sprint.find("idProject = ?1", project.id).first();


        //modifies the sprint
        Date date = new Date();
        SprintService.updateSprint(sprint, "description", 2, date, date);

        // Test
        assertNotNull(sprint);
        assertEquals(2, sprint.number);
        assertEquals("description", sprint.description);
        assertEquals(date, sprint.startDate);
        assertEquals(date, sprint.endDate);
    }


    @Test
    public void CCdeleteSprint(){
        // retrieve the sprint of a given project
        Project project = ProjectService.getProjectByName("sprinter le sujet");
        Sprint sprint = Sprint.find("idProject = ?1", project.id).first();

        // delete the sprint
        long idSprint = sprint.id;
        SprintService.deleteSprint(sprint);

        // Test
        assertNull(SprintService.getSprintById(idSprint));
    }


    /********
     * Epic *
     ********/

    @Test
    public void DAcreateAndRetrieveEpic() {
        // Create a new epic on a project and save it
        Project project = ProjectService.createProject("diviser le projet", "On va avoir besoin d'un diviseur", new Date());
        long idEpic = EpicService.createEpic("Epic une", "première epic", new Date(), project).id;

        // Retrieve the epic with it id
        Epic epic = EpicService.getEpicById(idEpic);

        // Test
        assertNotNull(epic);
        assertEquals("Epic une", epic.name);
    }

    @Test
    public void DBupdateEpic(){
        // retrieve the epic of a given project
        Project project = ProjectService.getProjectByName("diviser le projet");
        Epic epic = Epic.find("idProject = ?1", project.id).first();

        //modifies the sprint
        Date date = new Date();
        EpicService.updateEpic(epic, "Epic two", "deuxieme Epic", date);

        // Test
        assertNotNull(epic);
        assertEquals("Epic two", epic.name);
        assertEquals("deuxieme Epic", epic.description);
        assertEquals(date, epic.date);
    }

    @Test
    public void DCdeleteEpic(){
        // retrieve the epic of a given project
        Project project = ProjectService.getProjectByName("diviser le projet");
        Epic epic = Epic.find("idProject = ?1", project.id).first();

        // delete the sprint
        long idEpic = epic.id;
        EpicService.deleteEpic(epic);

        // Test
        assertNull(EpicService.getEpicById(idEpic));
    }


    /*********
     * Story *
     *********/

    @Test
    public void EAcreateAndRetrieveStory() {
        // Create a new story of an epic and save it
        Project project = ProjectService.getProjectByName("diviser le projet");
        Epic epic = EpicService.createEpic("nom epic", "description epic", new Date(),project);
        long idStory = StoryService.createStory("nom story", "description story", true, new Date(), epic).id;

        // Retrieve the epic with it id
        Story story = StoryService.getStoryById(idStory);

        // Test
        assertNotNull(story);
        assertEquals("nom story", story.name);
    }

    @Test
    public void EBupdateStory(){
        // retrieve the story
        Story story = Story.find("name = ?1", "nom story").first();

        //modifies the story
        Date date = new Date();
        StoryService.updateStory(story, "nom story 2", "description story 2", new Date());

        // Test
        assertNotNull(story);
        assertEquals("nom story 2", story.name);
        assertEquals("description story 2", story.description);
        assertEquals(date, story.date);
    }

    @Test
    public void ECdeleStory(){
        // retrieve the story
        Epic epic = Epic.find("name = ?1", "nom epic").first();
        Story story = Story.find("name = ?1", "nom story 2").first();

        // delete the story
        long idStory = story.id;
        StoryService.deleteStory(story);

        // Test
        assertNull(EpicService.getEpicById(idStory));
    }


    /********
     * Task *
     ********/

    @Test
    public void FAcreateAndRetrieveTask() {
        // Create a new task of a story and save it
        Epic epic = Epic.find("name = ?1", "nom epic").first();
        Story story = StoryService.createStory("nom story", "description story", true, new Date(), epic);
        Timestamp date = new Timestamp(new Date().getTime());
        long idTask = TaskService.createTask("nom task", "process task", "results task", " parameters task", date, story).id;

        // Retrieve the task with it id
        Task task = TaskService.getTaskById(idTask);

        // Test
        assertNotNull(task);
        assertEquals("nom task", task.name);
        assertEquals("process task", task.process);
        assertEquals("results task", task.results);
        assertEquals(" parameters task", task.parameters);
        assertEquals(date , task.date);
    }

    @Test
    public void FBupdateTask(){
        // retrieve the task
        Task task = Task.find("name = ?1", "nom task").first();

        //modifies the task
        Timestamp date = new Timestamp(new Date().getTime());
        TaskService.updateTask(task, "nom task 2", "process task 2", "results task 2", " parameters task 2", date);

        // Test
        assertNotNull(task);
        assertEquals("nom task 2", task.name);
        assertEquals("process task 2", task.process);
        assertEquals("results task 2", task.results);
        assertEquals(" parameters task 2", task.parameters);
        assertEquals(date , task.date);
    }

    @Test
    public void FCdeleTask(){
        // retrieve the task
        Task task = Task.find("name = ?1", "nom task 2").first();

        // delete the task
        long idTask = task.id;
        TaskService.deleteTask(task);

        // Test
        assertNull(TaskService.getTaskById(idTask));
    }


    /**********
     * Status *
     **********/

    @Test
    public void GAcreateAndRetrieveStatus() {
        // Create a new status of a task and save it
        Story story = Story.find("name = ?1", "nom story").first();
        Timestamp date = new Timestamp(new Date().getTime());
        Task task = TaskService.createTask("name task", "process task", "results",
                "parameters", date, story);
        long idStatus = StatusService.createStatus("label status", "action status", "remarks status",
                date, "description version", "description sprint", task).id;

        // Retrieve the task with it id
        Status status = StatusService.getStatusById(idStatus);

        // Test
        assertNotNull(status);
        assertEquals("label status", status.label);
        assertEquals("action status", status.action);
        assertEquals("remarks status", status.remarks);
        assertEquals("description version", status.descriptionVersion);
        assertEquals("description sprint", status.descriptionSprint);
        assertEquals(date , status.date);
    }


    @Test
    public void GBupdateStatus(){
        // retrieve the status
        Status status = Status.find("label = ?1", "label status").first();

        //modifies the status
        Timestamp date = new Timestamp(new Date().getTime());
        StatusService.updateStatus(status, "label status", "action status", "remarks status",
                date, "description version", "description sprint");

        // Test
        assertNotNull(status);
        assertEquals("label status", status.label);
        assertEquals("action status", status.action);
        assertEquals("remarks status", status.remarks);
        assertEquals("description version", status.descriptionVersion);
        assertEquals("description sprint", status.descriptionSprint);
        assertEquals(date , status.date);
    }


    @Test
    public void GCdeleStatus(){
        // retrieve the status
        Status status = Status.find("label = ?1", "label status").first();

        // delete the task
        long idStatus = status.id;
        StatusService.deleteStatus(status);

        // Test
        assertNull(StatusService.getStatusById(idStatus));
    }
}
