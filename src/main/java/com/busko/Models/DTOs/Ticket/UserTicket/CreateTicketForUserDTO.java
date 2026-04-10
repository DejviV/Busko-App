package com.busko.Models.DTOs.Ticket.UserTicket;

import com.busko.Models.SubRoute;
import com.busko.Models.Ticket;
import com.busko.Models.TimedRoute;
import com.busko.Models.User;

public record CreateTicketForUserDTO(
        Long subRouteId,
        Long timeRouteId,
        Long userId,
        boolean returnTicket,
        String travelDate
)
{

    public Ticket toTicket(SubRoute subRoute, TimedRoute timedRoute, User user, int seatNumber) {
        return Ticket.createForUser(
                timedRoute,
                subRoute,
                user,
                returnTicket,
                seatNumber,
                java.time.LocalDate.parse(travelDate)
        );
    }
}
