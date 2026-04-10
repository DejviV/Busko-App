package com.busko.Models.DTOs.Ticket.GuestTicket;

import com.busko.Models.SubRoute;
import com.busko.Models.Ticket;
import com.busko.Models.TimedRoute;

public record CreateTicketForGuestDTO(
        Long subRouteId,
        Long timeRouteId,
        boolean returnTicket,
        String travelDate,
        String contactInfo
)
{
    public Ticket toTicket(SubRoute subRoute, TimedRoute timedRoute, int seatNumber) {
        return Ticket.createForGuest(
                timedRoute,
                subRoute,
                contactInfo,
                returnTicket,
                seatNumber,
                java.time.LocalDate.parse(travelDate)
        );
    }
}
