package com.busko.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

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

    private boolean returnTicket;
    private boolean isScannedOutbound;
    private boolean isScannedReturn;

    @Column(nullable = true)
    private String contactInfo; // email or phone for non-logged in users

    private int seatNumber;
    private LocalDate travelDate;
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
        t.validUntil = travelDate.plusDays(28).atStartOfDay();
        t.isScannedOutbound = false;
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
        t.validUntil = travelDate.plusDays(28).atStartOfDay();
        t.isScannedOutbound = false;
        t.isScannedReturn = false;
        return t;
    }

}



