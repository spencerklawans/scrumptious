package com.scrumptious.logic.backend.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TicketTest {

    @Test
    public void testTitle() {
        Ticket ticket = new Ticket();

        assertEquals(null, ticket.getTitle());

        ticket.setTitle("Hello World");

        assertEquals("Hello World", ticket.getTitle());
    }

    @Test
    public void testAssignees() {
        //TODO update with emails(?) and actual assignee mechanism
        ArrayList<String> assignees = new ArrayList<>();
        assignees.add("John Smith");
        assignees.add("Jane Doe");
        assignees.add("Billy Bob");

        Ticket ticket = new Ticket();

        for (String assignee : assignees) {
            ticket.addAssignee(assignee);
        }

        assertEquals(3, ticket.getAssignees().size());
    }
}
