package com.scrumptious.logic.backend.controller;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.scrumptious.logic.backend.entity.Project;

class ProjectControllerTest {

    //TODO: decompose addProject into `Project generateProject()` and a repository/database update
    //TODO: more tests when ProjC further decomposed

    @Test
    void addProjectOne() {
        //Generic add project test
        String name = "This is a test";
        String description = "This project is a dummy project for the purpose of unit testing.";
        LocalDate date = LocalDate.now();
        String team = "test_email99@example.com, email1@email.com, real_mail101@definitely.real.net";

        ProjectController pc = new ProjectController();

        assertEquals(new Project(), pc.addProject(name, description, date, team));
        

    }

    @Test
    void addProjectTwo() {
        //No date test
        String name = "This is a test";
        String description = "This project is a dummy project for the purpose of unit testing.";

        String team = "test_email99@example.com, email1@email.com, real_mail101@definitely.real.net";

        ProjectController pc = new ProjectController();

        assertEquals(new Project(), pc.addProject(name, description, null, team));
    }

}