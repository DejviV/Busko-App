package com.busko.Models.Enums;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ID;
    private String SubRouteID;
    private String UserID;
    private boolean ReturnTicket;
    private boolean IsScanned;
    private String NumberOREmail;
    private String SeatNumber;
    private String DateTime;
    private String ValidDateTime;

    public Ticket() {}

    public Ticket(String subRouteID, String userID, boolean returnTicket, boolean isScanned, String numberOREmail, String seatNumber, String dateTime, String validDateTime) {
        this.SubRouteID = subRouteID;
        this.UserID = userID;
        this.ReturnTicket = returnTicket;
        this.IsScanned = isScanned;
        this.NumberOREmail = numberOREmail;
        this.SeatNumber = seatNumber;
        this.DateTime = dateTime;
        this.ValidDateTime = validDateTime;
    }
}
