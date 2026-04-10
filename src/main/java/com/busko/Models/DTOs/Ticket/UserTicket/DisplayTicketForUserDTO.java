package com.busko.Models.DTOs.Ticket.UserTicket;

import com.busko.Models.*;

public record DisplayTicketForUserDTO(
        String routeName,
        String subRouteName,
        String userNameAndSurname,
        String companyName,
        int seatNumber,
        String travelDate,
        String validUntil,
        String returnTicket
)

{
    public static DisplayTicketForUserDTO from(Ticket ticket) {

        return new DisplayTicketForUserDTO(
                ticket.getTimedRoute().getRoute().getName(),
                ticket.getSubRoute().getName(),
                ticket.getUser().getNameAndSurname(),
                ticket.getTimedRoute().getRoute().getCompany().getNameAndSurname(),
                ticket.getSeatNumber(),
                ticket.getTravelDate().toString(),
                ticket.getValidUntil().toString(),
                String.valueOf(ticket.isReturnTicket())
        );
    }

}
