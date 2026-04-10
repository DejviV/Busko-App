package com.busko.Models.DTOs.Ticket.GuestTicket;

import com.busko.Models.Ticket;

public record DisplayTicketForGuestDTO(
        String routeName,
        String subRouteName,
        String contactInfo,
        String companyName,
        int seatNumber,
        String travelDate,
        String validUntil,
        String returnTicket
) {
    public static DisplayTicketForGuestDTO from(Ticket ticket) {

        return new DisplayTicketForGuestDTO(
                ticket.getTimedRoute().getRoute().getName(),
                ticket.getSubRoute().getName(),
                ticket.getContactInfo(),
                ticket.getTimedRoute().getRoute().getCompany().getNameAndSurname(),
                ticket.getSeatNumber(),
                ticket.getTravelDate().toString(),
                ticket.getValidUntil().toString(),
                String.valueOf(ticket.isReturnTicket())
        );
    }
}
