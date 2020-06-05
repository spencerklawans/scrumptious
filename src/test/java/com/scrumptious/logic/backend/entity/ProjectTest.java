package com.scrumptious.logic.backend.entity;

import static org.junit.Assert.*;

import org.junit.Test;


public class ProjectTest {

    @Test
    public void testName() {
        Project p = new Project();

        assertEquals(null, p.getName());

        p.setName("Hello World");

        assertEquals("Hello World", p.getName());
    }

    @Test
    public void testCreator() {
        Project p = new Project();

        assertEquals(null, p.getCreator());

        p.setCreator("Me");

        assertEquals("Me", p.getCreator());
    }
}
