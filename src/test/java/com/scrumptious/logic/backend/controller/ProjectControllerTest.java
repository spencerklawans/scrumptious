package com.scrumptious.logic.backend.controller;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.scrumptious.logic.backend.entity.Project;

public class ProjectControllerTest {

    @Test
    public void addProjectOne() {
        //Generic add project test
        String name = "This is a test";
        String description = "This project is a dummy project for the purpose of unit testing.";
        LocalDate date = LocalDate.now();
        String team = "test_email99@example.com, email1@email.com, real_mail101@definitely.real.net";

        ProjectController pc = new ProjectController();

        assertEquals(pc.addProject(name, description, date, team).getName(), name);
        

    }

    @Test
    public void addProjectTwo() {
        //No date test
        String name = "This is a test";
        String description = "This project is a dummy project for the purpose of unit testing.";

        String team = "test_email99@example.com, email1@email.com, real_mail101@definitely.real.net";

        ProjectController pc = new ProjectController();

        assertEquals(pc.addProject(name, description, null, team).getDescription(), description);
    }

}