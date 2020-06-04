package com.scrumptious.logic.backend.controller;

import org.junit.Before;
import org.junit.Test;

import com.scrumptious.logic.backend.entity.Project;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class AdvancedProjectTest {
    @Before
    public void setup() {
        Project p = new Project();
        Project pDate = new Project(LocalDate.now().minusDays(10));
    }

    @Test
    public void testTeam() {
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
    public void testDate() {
        Project p = new Project();
        Project pDate = new Project(LocalDate.now().minusDays(10));

        assertNotEquals(null, p.getDateCreated());
        assertEquals(LocalDate.now(), p.getDateCreated());

        LocalDate date = LocalDate.now().minus(10, ChronoUnit.DAYS);

        assertEquals(date, pDate.getDateCreated());
    }
}
