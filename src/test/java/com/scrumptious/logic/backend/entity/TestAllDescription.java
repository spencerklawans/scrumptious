package com.scrumptious.logic.backend.entity;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestAllDescription {

    @Test
    public void testProjectDescription() {
        Project p = new Project();

        assertEquals(null, p.getDescription());

        p.setDescription("This is a test.");

        assertEquals("This is a test.", p.getDescription());
    }

    @Test
    public void testTicketDescription() {
        Ticket ticket = new Ticket();

        assertNull(ticket.getDescription());

        ticket.setDescription("This is a test ticket description.");

        assertEquals("This is a test ticket description.", ticket.getDescription());
    }
}
