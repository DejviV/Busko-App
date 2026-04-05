package com.busko.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TimedRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    @JoinColumn (name = "route_id")
    private Route route;
    private String startTime;
    private String endTime;
    private String day;
    private String date;
    private int numSeats;

    public TimedRoute() {}

    public TimedRoute(Route Route, String startTime, String endTime, String day, String date, int numSeats) {
        this.route = Route;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
        this.date = date;
        this.numSeats = numSeats;
    }
}
