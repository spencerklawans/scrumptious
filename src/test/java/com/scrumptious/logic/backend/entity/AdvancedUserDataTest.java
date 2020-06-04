package com.scrumptious.logic.backend.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdvancedUserDataTest {
    @Test
    public void testAddProject() {
        UserData ud = new UserData();
        ud.getProjects().add(1L);
        assertEquals(ud.getProjects().size(), 1);
    }

    @Test
    public void testRemoveProject() {
        UserData ud = new UserData("test@test.com");
        ud.getProjects().add(1L);
        ud.getProjects().remove(1L);
        assertEquals(ud.getProjects().size(), 0);
    }
}
