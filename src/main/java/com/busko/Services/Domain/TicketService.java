package com.busko.Services.Domain;

import com.busko.Models.Ticket;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> getAllTickets();
    Optional<Ticket> getTicketById(Long id);
    Optional<Ticket> deleteTicket(Long id);
    Ticket createTicketForUser(Long timedRouteId, Long subRouteId, Long userId,
                               boolean returnTicket, LocalDate travelDate);
    Ticket createTicketForGuest(Long timedRouteId, Long subRouteId, String contactInfo,
                                boolean returnTicket, LocalDate travelDate);
}
