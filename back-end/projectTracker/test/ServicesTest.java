import models.Project;
import org.junit.Test;
import play.test.UnitTest;
import services.ProjectService;

import java.util.Date;

/**
 * Created by formation on 03/04/17.
 */
public class ServicesTest extends UnitTest {

    /***********
     * PROJECT *
     ***********/

    @Test
    public void createAndRetrieveProject() {
        // Create a new project and save it
        ProjectService.createProject("Mettre théo sur orbite", "On va avoir besoin d'une fusée", new Date());

        // Retrieve the user with it name
        Project mtso = Project.find("byName", "Mettre théo sur orbite").first();

        // Test
        assertNotNull(mtso);
        assertEquals("Mettre théo sur orbite", mtso.name);
    }


    @Test
    public void updateProject(){
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
    public void deleteProject(){
        // retrieve the project by its name
        Project mtso = ProjectService.getProjectByName("Mettre théo sur orbite");

        // delete the project
        ProjectService.deleteProject(mtso.id);

        // Test
        assertNull(ProjectService.getProjectById(mtso.id));
    }


    /***********
     * VERSION *
     ***********/

    @Test
    public void createAndRetrieveVersion() {
        // Create a new Version on a project and save it
        ProjectService.createProject("Mettre théo sur orbite", "On va avoir besoin d'une fusée", new Date());

        // Retrieve the user with it name
        Project mtso = Project.find("byName", "Mettre théo sur orbite").first();

        // Test
        assertNotNull(mtso);
        assertEquals("Mettre théo sur orbite", mtso.name);
    }
}
