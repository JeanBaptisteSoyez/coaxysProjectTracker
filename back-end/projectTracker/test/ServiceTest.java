import models.User;
import org.junit.Test;
import play.test.UnitTest;
import services.UserService;

/**
 * Created by formation on 30/03/17.
 */
public class ServiceTest extends UnitTest {

    @Test
    public void createAndRetrieveUser() {
        // Create a new user and save it
        UserService.createUser("Téo Dinel", "protecteur de la virilité", "theo@fdsdf.com", "bloup");

        // Retrieve the user with e-mail address bob@gmail.com
        User teo = User.find("email = ?1", "theo@fdsdf.com").first();

        // Test
        assertNotNull(teo);
        assertEquals("Téo Dinel", teo.name);
    }

    @Test
    public void deleteUser(){
        // Create a new user and save it
        UserService.createUser("Téo Dinel", "protecteur de la virilité", "theo@fdsdf.com", "bloup");

        // Retrieve the user with e-mail address bob@gmail.com
        User teo = User.find("email = ?1", "theo@fdsdf.com").first();
        //Delete this user
        UserService.deleteUser("theo@fdsdf.com");

        // Test
        assertNull(teo);
    }
}
