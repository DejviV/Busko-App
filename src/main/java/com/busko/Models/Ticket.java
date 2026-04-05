package com.busko.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long subRouteId;
    private String userId = null;
    private boolean returnTicket;
    private boolean isScanned;
    @Nullable
    private String numberOREmail = null;
    private String seatNumber;
    private String dateTime;
    private String validDateTime;

    public Ticket() {}

    public Ticket(Long subRouteID, String userID, boolean returnTicket, boolean isScanned, String numberOREmail, String seatNumber, String dateTime, String validDateTime) {
        this.subRouteId = subRouteID;
        this.userId = userID;
        this.returnTicket = returnTicket;
        this.isScanned = isScanned;
        this.numberOREmail = numberOREmail;
        this.seatNumber = seatNumber;
        this.dateTime = dateTime;
        this.validDateTime = validDateTime;
    }
}
