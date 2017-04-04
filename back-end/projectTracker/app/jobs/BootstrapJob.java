package jobs;

import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

/**
 * Created by formation on 03/04/17.
 */
@OnApplicationStart
public class BootstrapJob extends Job {

    @Override
    public void doJob() throws Exception {
//        System.out.println("DEMMARAGE");
//        Fixtures.deleteDatabase();
    }
}