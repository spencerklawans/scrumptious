package com.scrumptious.logic.backend.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TicketTest {

    @Test
    void testTitle() {
        Ticket ticket = new Ticket();

        assertEquals(null, ticket.getTitle());

        ticket.setTitle("Hello World");

        assertEquals("Hello World", ticket.getTitle());
    }

    @Test
    void testPriority() {
        Ticket ticket = new Ticket();

        assertEquals(null, ticket.getPriority());

        ticket.setPriority(PriorityEnum.LOW);
        assertEquals(PriorityEnum.LOW, ticket.getPriority());

        ticket.setPriority(PriorityEnum.MEDIUM);
        assertEquals(PriorityEnum.MEDIUM, ticket.getPriority());

        ticket.setPriority(PriorityEnum.HIGH);
        assertEquals(PriorityEnum.HIGH, ticket.getPriority());
    }

    @Test
    void testStatus() {
        Ticket ticket = new Ticket();

        assertEquals(null, ticket.getStatus());

        ticket.setStatus(StatusEnum.TODO);
        assertEquals(StatusEnum.TODO, ticket.getPriority());

        ticket.setStatus(StatusEnum.INPROGRESS);
        assertEquals(StatusEnum.INPROGRESS, ticket.getPriority());

        ticket.setStatus(StatusEnum.DONE);
        assertEquals(StatusEnum.DONE, ticket.getPriority());

        ticket.setStatus(StatusEnum.BACKLOG);
        assertEquals(StatusEnum.BACKLOG, ticket.getPriority());

        ticket.setStatus(StatusEnum.OVERDUE);
        assertEquals(StatusEnum.OVERDUE, ticket.getPriority());
    }

    @Test
    void testAssignees() {
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

    @Test
    void testDescription() {
        Ticket ticket = new Ticket();

        assertNull(ticket.getDescription());

        ticket.setDescription("This is a test ticket description.");

        assertEquals("This is a test ticket description.", ticket.getDescription());
    }

    //TODO: ADD testDueDate





}