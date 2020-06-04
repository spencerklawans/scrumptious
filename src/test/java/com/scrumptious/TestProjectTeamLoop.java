package com.scrumptious;

import com.scrumptious.logic.Application;
import com.scrumptious.logic.backend.controller.ProjectController;
import com.scrumptious.logic.backend.entity.Project;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// tests team loop under possible conditions and ensures there is no error and result is as expected
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestProjectTeamLoop
{
    ProjectController pc = new ProjectController();

    // assert that if there are no users and user adding loop runs 0 times, the only user is creator
    @Test
    public void testTeamLoopNoRuns() {
        String team = "";
        Project p = pc.addProject("test", "test", null, team);
        Assert.assertEquals(p.getUsers().size(), 1);
    }

    // assert that adding one user returns two users (user added and creator)
    @Test
    public void testTeamLoopOneRun() {
        String team = "test2@test.com";
        Project p = pc.addProject("test", "test", null, team);
        Assert.assertEquals(p.getUsers().size(), 2);
    }

    // assert that adding n users returns n + 1 users (users added and creator)
    @Test
    public void testTeamLoopMultipleRuns() {
        String team = "test2@test.com, test3@test.com, test4@test.com";
        Project p = pc.addProject("test", "test", null, team);
        Assert.assertEquals(p.getUsers().size(), 4);
    }
}
