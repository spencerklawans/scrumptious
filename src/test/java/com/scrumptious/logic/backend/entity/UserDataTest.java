package com.scrumptious.logic.backend.entity;

import com.scrumptious.logic.backend.controller.ProjectController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserDataTest {

    @Test
    public void testProjectList() {
        UserData ud = new UserData();
        assertEquals(ud.getProjects().size(), 0);
    }

    @Test
    public void testEmail() {
        UserData ud = new UserData("test@test.com");
        assertEquals("test@test.com", ud.getEmail());
    }
}
