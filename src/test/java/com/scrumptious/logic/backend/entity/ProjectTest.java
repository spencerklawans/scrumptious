package com.scrumptious.logic.backend.entity;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;


class ProjectTest {

    @Before
    void setup() {
        Project p = new Project();
        Project pDate = new Project(LocalDate.now().minusDays(10));
    }


    @Test
    void testName() {
        Project p = new Project();

        assertEquals(null, p.getName());

        p.setName("Hello World");

        assertEquals("Hello World", p.getName());
    }

    @Test
    void testCreator() {
        Project p = new Project();

        assertEquals(null, p.getCreator());

        p.setCreator("Me");

        assertEquals("Me", p.getCreator());
    }

    @Test
    void testDescription() {
        Project p = new Project();

        assertEquals(null, p.getDescription());

        p.setDescription("This is a test.");

        assertEquals("This is a test.", p.getDescription());
    }

    @Test
    void testTeam() {
        Project p = new Project();

        ArrayList<String> teamEmails = new ArrayList<String>();
        teamEmails.add("useless_info@email.mail"); teamEmails.add("mail@example.uk");
        teamEmails.add("that_one_guy999@legit.domain.com");

        assertTrue(p.getUsers().isEmpty());

        p.setUserEmails(teamEmails);

        assertFalse(p.getUsers().isEmpty());
        assertEquals(3, p.getUsers().size());

        p.addMember("this_is_my_email@example.example");

        assertEquals(4, p.getUsers().size());

    }

    @Test
    void testDate() {
        Project p = new Project();
        Project pDate = new Project(LocalDate.now().minusDays(10));

        assertNotEquals(null, p.getDateCreated());
        assertEquals(LocalDate.now(), p.getDateCreated());

        LocalDate date = LocalDate.now().minus(10, ChronoUnit.DAYS);

        assertEquals(date, pDate.getDateCreated());
    }

}
