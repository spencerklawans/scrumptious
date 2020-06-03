package com.scrumptious.logic.backend.repository;

import com.scrumptious.logic.backend.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
    List<Ticket> findByPid(Long pid);
}
