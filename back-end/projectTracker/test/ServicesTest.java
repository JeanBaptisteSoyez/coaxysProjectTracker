import models.Project;
import models.Version;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import play.test.Fixtures;
import play.test.UnitTest;
import services.ProjectService;
import services.VersionService;

import java.util.Date;

/**
 * Created by formation on 03/04/17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServicesTest extends UnitTest {

    @BeforeClass
    public static void initDB(){
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
        Project mtso = ProjectService.createProject("Mettre théo sur orbite", "On va avoir besoin d'une fusée", new Date());
        long idVersion = VersionService.createVersion("version une", 1, new Date(), new Date(), mtso.id).id;

        // Retrieve the user with it id
        Version version = VersionService.getVersionById(idVersion);

        // Test
        assertNotNull(version);
        assertEquals("version une", version.description);
    }
}
