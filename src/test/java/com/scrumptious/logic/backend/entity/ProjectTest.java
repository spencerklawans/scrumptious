package com.scrumptious.logic.backend.entity;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;


class ProjectTest {

    @Before
    public void setup() {
        Project p = new Project();
        Project pDate = new Project(LocalDate.now().minusDays(10));
    }


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
