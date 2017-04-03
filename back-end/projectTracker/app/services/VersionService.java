package services;

import models.Project;
import models.Version;

import java.util.Date;

/**
 * Created by formation on 03/04/17.
 */
public class VersionService {

    public static Version createVersion(String description, int number, Date startDate, Date endDate, Long idProject) {
        Project project = ProjectService.getProjectById(idProject);
        Version version = new Version(startDate, endDate, description, number, project);
        version.save();
        return version;
    }

    public static Version getVersionById(long idVersion) {
        return Version.findById(idVersion);
    }
}
