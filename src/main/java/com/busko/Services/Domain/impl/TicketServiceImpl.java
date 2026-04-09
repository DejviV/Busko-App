package com.busko.Services.Domain.impl;

import com.busko.Models.Exeptions.NoSeatsRemainingExeption;
import com.busko.Models.SubRoute;
import com.busko.Models.Ticket;
import com.busko.Models.TimedRoute;
import com.busko.Models.User;
import com.busko.Repository.SubRouteRepository;
import com.busko.Repository.TicketRepository;
import com.busko.Repository.TimedRouteRepository;
import com.busko.Repository.UserRepository;
import com.busko.Services.Domain.SubRouteService;
import com.busko.Services.Domain.TicketService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final SubRouteRepository subRouteRepository;
    private final TimedRouteRepository timedRouteRepository;
    private final UserRepository userRepository;

    public TicketServiceImpl(TicketRepository ticketRepository,  SubRouteRepository subRouteRepository,
                             TimedRouteRepository timedRouteRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.subRouteRepository = subRouteRepository;
        this.timedRouteRepository = timedRouteRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
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


    @Override
    public Ticket createTicketForUser(Long timedRouteId, Long subRouteId, Long userId,
                                      boolean returnTicket, LocalDate travelDate) {
        TimedRoute timedRoute = timedRouteRepository.findById(timedRouteId).orElseThrow();
        SubRoute subRoute = subRouteRepository.findById(subRouteId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();

        if (timedRoute.getNumSeatsRemaining() <= 0)
            throw new NoSeatsRemainingExeption();

        timedRoute.decreaseNumSeatsRemaining();
        timedRouteRepository.save(timedRoute);
        int seatNumber = timedRoute.getNumSeats() - timedRoute.getNumSeatsRemaining(); // assign the next available seat number

        Ticket ticket = Ticket.createForUser(timedRoute, subRoute, user,
                returnTicket, seatNumber, travelDate);
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket createTicketForGuest(Long timedRouteId, Long subRouteId, String contactInfo,
                                       boolean returnTicket, LocalDate travelDate) {
        TimedRoute timedRoute = timedRouteRepository.findById(timedRouteId).orElseThrow();
        SubRoute subRoute = subRouteRepository.findById(subRouteId).orElseThrow();

        if (timedRoute.getNumSeatsRemaining() <= 0)
            throw new RuntimeException("No seats remaining");

        timedRoute.decreaseNumSeatsRemaining();
        timedRouteRepository.save(timedRoute);
        int seatNumber = timedRoute.getNumSeats() - timedRoute.getNumSeatsRemaining(); // assign the next available seat number

        Ticket ticket = Ticket.createForGuest(timedRoute, subRoute, contactInfo,
                returnTicket, seatNumber, travelDate);
        return ticketRepository.save(ticket);
    }


}