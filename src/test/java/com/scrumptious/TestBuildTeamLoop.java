package com.scrumptious;

import com.scrumptious.logic.Application;
import com.scrumptious.logic.backend.controller.ProjectController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

// tests project components loop under possible conditions and ensures there is no error and result is as expected
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestBuildTeamLoop
{
    ProjectController pc = new ProjectController();
    //assert that if there are no projects and project component loop runs 0 times, there are 0 project components
    @Test
    public void buildLoopNoRuns() {
        String team = "";
        List<String> teamList = pc.buildTeam(team);
        Assert.assertEquals(teamList.size(), 0);
    }

    @Test
    public void buildLoopOneRun() {
        String team = "abc@gmail.com";
        List<String> teamList = pc.buildTeam(team);
        Assert.assertEquals(teamList.size(), 1);
    }

    @Test
    public void buildLoopMultiRuns() {
        String team = "abc@gmail.com, def@gmail.com";
        List<String> teamList = pc.buildTeam(team);
        Assert.assertEquals(teamList.size(), 2);
    }
}

