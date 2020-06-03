import com.scrumptious.logic.backend.controller.ProjectController;
import com.scrumptious.logic.backend.controller.UserDataController;
import com.scrumptious.logic.backend.entity.Project;
import com.scrumptious.logic.ui.ProjectMiniComponent;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// tests project components loop under possible conditions and ensures there is no error and result is as expected
public class TestProjectComponentsLoop
{
    ProjectController pc = new ProjectController();
    UserDataController udc = new UserDataController();

    // assert that if there are no projects and project component loop runs 0 times, there are 0 project components
//    @Test
////    public void pmcLoopNoRuns() {
////        ArrayList<Long> projects = new ArrayList<Long>();
////        List<ProjectMiniComponent> pmcList = pc.buildProjComponents(projects);
////        Assert.assertEquals(pmcList.size(), 0);
////    }

//    // assert that project mini component list is correct with only one project
//    @Test
//    public void pmcLoopOneRun() {
//        ArrayList<Long> projects = new ArrayList<Long>();
//        pc.addProject("test", "test", null, "");
//        List<ProjectMiniComponent> pmcList = pc.buildProjComponents();
//        Assert.assertEquals(pmcList.size(), 0);
//    }

    // assert that project mini component list is correct with multiple projects
//    @Test
//    public void pmcLoopMultipleRuns() {
//        ArrayList<Long> projects = new ArrayList<Long>();
//        List<ProjectMiniComponent> pmcList = pc.buildProjComponents(projects);
//        Assert.assertEquals(pmcList.size(), 0);
//    }
}

