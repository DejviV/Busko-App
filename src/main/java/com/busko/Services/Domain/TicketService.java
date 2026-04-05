package com.busko.Services.Domain;

import com.busko.Models.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> getAllTickets();
    Optional<Ticket> getTicketById(Long id);
    Ticket createTicket(Ticket ticket);
    Optional<Ticket> deleteTicket(Long id);
}
