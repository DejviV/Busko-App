package com.busko.Services.Domain.impl;

import com.busko.Models.Ticket;
import com.busko.Repository.TicketRepository;
import com.busko.Services.Domain.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    /* You don't update a ticket
    public Optional<Ticket> updateTicket(Long id, Ticket ticket)
    */

    @Override
    public Optional<Ticket> deleteTicket(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        ticket.ifPresent(ticketRepository::delete);
        return ticket;
    }
}