import models.Epic;
import models.Project;
import models.Sprint;
import models.Version;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import play.test.Fixtures;
import play.test.UnitTest;
import services.EpicService;
import services.ProjectService;
import services.SprintService;
import services.VersionService;

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
}
