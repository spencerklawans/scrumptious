import com.scrumptious.logic.backend.controller.ProjectController;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class LoopTests
{
    ProjectController pc;

    @Before
    public void setupData() {
        pc = new ProjectController();

    }

    @Test
    public void testTeamLoop() {
        String team = "";
        pc.addProject("test", "test", LocalDate.now(), team);
    }
}
