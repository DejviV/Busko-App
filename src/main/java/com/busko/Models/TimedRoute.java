package com.busko.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TimedRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ID;
    private String RouteID;
    private String StartTime;
    private String EndTime;
    private String Day;
    private String Date;
    private int NumSeats;

    public TimedRoute() {}

    public TimedRoute(String routeID, String startTime, String endTime, String day, String date, int numSeats) {
        this.RouteID = routeID;
        this.StartTime = startTime;
        this.EndTime = endTime;
        this.Day = day;
        this.Date = date;
        this.NumSeats = numSeats;
    }
}
