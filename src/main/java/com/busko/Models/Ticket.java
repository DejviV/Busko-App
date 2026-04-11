package com.busko.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timed_route_id")
    private TimedRoute timedRoute;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_route_id")
    private SubRoute subRoute;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    private User user; // null if guest
    @Column(nullable = true)
    private String contactInfo; // email or phone for non-logged in users

    private boolean returnTicket;
    private boolean isScannedOutbound;
    private boolean isScannedReturn;
    private int seatNumber;


    @Column(nullable = false)
    private LocalDate travelDate;
    @Column(nullable = false)
    private LocalDateTime validUntil;

    // registered user
    public static Ticket createForUser(TimedRoute timedRoute, SubRoute subRoute, User user,
                                       boolean returnTicket, int seatNumber, LocalDate travelDate) {
        Ticket t = new Ticket();
        t.timedRoute = timedRoute;
        t.subRoute = subRoute;
        t.user = user;
        t.contactInfo = null;
        t.returnTicket = returnTicket;
        t.seatNumber = seatNumber;
        t.travelDate = travelDate;
        if(returnTicket) {
            t.validUntil = travelDate.plusDays(28).atStartOfDay();
        } else {
            t.validUntil = travelDate.atTime(23, 59);
        }        t.isScannedOutbound = false;
        t.isScannedReturn = false;
        return t;
    }


    // guest
    public static Ticket createForGuest(TimedRoute timedRoute, SubRoute subRoute, String contactInfo,
                                        boolean returnTicket, int seatNumber, LocalDate travelDate) {
        Ticket t = new Ticket();
        t.timedRoute = timedRoute;
        t.subRoute = subRoute;
        t.user = null;
        t.contactInfo = contactInfo;
        t.returnTicket = returnTicket;
        t.seatNumber = seatNumber;
        t.travelDate = travelDate;
        if(returnTicket) {
            t.validUntil = travelDate.plusDays(28).atStartOfDay();
        } else {
            t.validUntil = travelDate.atTime(23, 59);
        }
        t.isScannedOutbound = false;
        t.isScannedReturn = false;
        return t;
    }

}



