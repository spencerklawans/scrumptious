package com.scrumptious.logic.backend.controller;

import com.scrumptious.logic.backend.entity.PriorityEnum;
import com.scrumptious.logic.backend.entity.StatusEnum;
import com.scrumptious.logic.backend.repository.TicketRepository;
import com.scrumptious.logic.backend.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketController {

	@Autowired
	ProjectController pc;

	@Autowired
	TicketRepository tr;

    public void addTicket(String title, PriorityEnum pe, StatusEnum se, ArrayList<String> assigneeEmails,
						  String description, LocalDate assigned, LocalDate dueDate, Long pid)
    {
    	GoogleCalendarController gcc = new GoogleCalendarController();
        Ticket t = new Ticket(title, pe, se, assigneeEmails, description, assigned, dueDate, pid);
        tr.save(t);
        
        try {
			gcc.addTicketToGCal(t);
		} catch (IOException e) {
			//TODO: Add exception handling
			return;
		}
    }

    public List<Ticket> findTicketsByPid(Long pid)
    {
        return tr.findByPid(pid);
    }

	public void updateTicket(String title, String description, LocalDate dueDate, String priority, String status,
							 ArrayList<String> emails, int ticketIndex, Long pid){
		Ticket t = findTicketsByPid(pid).get(ticketIndex); 
		t.setTitle(title);
		t.setDescription(description);
		t.setDueDate(dueDate);
		t.setPriority(getPriorityEnum(priority));
		t.setStatus(getStatusEnum(status));
		t.setAssigneeEmails(emails);
		tr.save(t); 
	}
	
	public void addBacklog(String title, String description, String priority, Long pid) {
		Ticket t = new Ticket(title, getPriorityEnum(priority), StatusEnum.BACKLOG, null, description, null, null, pid); 
		tr.save(t); 
	}
	
	public PriorityEnum getPriorityEnum(String priority) {
		if (priority.equals("Low"))
			return PriorityEnum.LOW; 
		else if (priority.equals("Medium"))
			return PriorityEnum.MEDIUM; 
		else 
			return PriorityEnum.HIGH; 
	}
	
	public StatusEnum getStatusEnum(String status) {
		if (status.equals("To Do"))
			return StatusEnum.TODO; 
		else if (status.equals("In Progress")) 
			return StatusEnum.INPROGRESS; 
		else
			return StatusEnum.DONE; 
	}
	
	public String getTicketTitle(int index, Long pid) {
		Ticket t = findTicketsByPid(pid).get(index); 
		return t.getTitle(); 
	}
	
	public String getTicketDescription(int index, Long pid) {
		Ticket t = findTicketsByPid(pid).get(index); 
		return t.getDescription(); 
	}
	
	public LocalDate getDateAssigned(int index, Long pid) {
		Ticket t = findTicketsByPid(pid).get(index); 
		return t.getAssigned(); 
	}
	
	public LocalDate getDateDue(int index, Long pid) {
		Ticket t = findTicketsByPid(pid).get(index); 
		return t.getDueDate();  
	}
	
	public String getPriority(int index, Long pid) {
		Ticket t = findTicketsByPid(pid).get(index);
		if (t.getPriority().equals(PriorityEnum.LOW)) 
			return "Low"; 
		else if (t.getPriority().equals(PriorityEnum.MEDIUM))
			return "Medium"; 
		else 
			return "High"; 
	}
	
	public String getStatus(int index, Long pid) {
		Ticket t = findTicketsByPid(pid).get(index);
		if (t.getStatus().equals(StatusEnum.TODO))
			return "To Do"; 
		else if (t.getStatus().equals(StatusEnum.INPROGRESS))
			return "In Progress";
		else
			return "Completed"; 
	}
	
	public List<String> getAssignees(int index, Long pid) {
		Ticket t = findTicketsByPid(pid).get(index); 
		return t.getAssignees();  
	}

}
