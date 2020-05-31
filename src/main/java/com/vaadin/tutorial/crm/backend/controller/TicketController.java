package com.vaadin.tutorial.crm.backend.controller;

import com.vaadin.tutorial.crm.backend.entity.PriorityEnum;
import com.vaadin.tutorial.crm.backend.entity.Project;
import com.vaadin.tutorial.crm.backend.entity.StatusEnum;
import com.vaadin.tutorial.crm.backend.entity.Ticket;
import com.vaadin.tutorial.crm.backend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketController {

	@Autowired
	ProjectController pc = new ProjectController();

	@Autowired
    TicketRepository tr;

    public void addTicket(String title, PriorityEnum pe, StatusEnum se, ArrayList<String> assigneeEmails,
                          String description, LocalDate assigned, LocalDate dueDate, Long pid)
    {
        Ticket t = new Ticket(title, pe, se, assigneeEmails, description, assigned, dueDate, pid);
        tr.save(t);
    }

    public List<Ticket> findTicketsByPid(Long pid)
    {
        return tr.findByPid(pid);
    }

	public void updateTicket(String reference){
        //boundary-facing method for accessing database info and updating info
		//TODO: this needs to be fixed

        //query database for info

        //fill a ticket
//        Ticket ticket = getNewTicket(reference);


        //push data back to database
        //should return JSON to be passed to database method
	}

}
