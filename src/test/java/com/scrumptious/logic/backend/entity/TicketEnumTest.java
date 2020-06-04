package com.scrumptious.logic.backend.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicketEnumTest {
    @Test
    public void testPriority() {
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
    public void testStatus() {
        Ticket ticket = new Ticket();

        assertEquals(null, ticket.getStatus());

        ticket.setStatus(StatusEnum.TODO);
        assertEquals(StatusEnum.TODO, ticket.getStatus());

        ticket.setStatus(StatusEnum.INPROGRESS);
        assertEquals(StatusEnum.INPROGRESS, ticket.getStatus());

        ticket.setStatus(StatusEnum.DONE);
        assertEquals(StatusEnum.DONE, ticket.getStatus());

        ticket.setStatus(StatusEnum.BACKLOG);
        assertEquals(StatusEnum.BACKLOG, ticket.getStatus());

        ticket.setStatus(StatusEnum.OVERDUE);
        assertEquals(StatusEnum.OVERDUE, ticket.getStatus());
    }
}
