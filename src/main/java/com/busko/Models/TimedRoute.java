package com.busko.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TimedRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private Route route;

    private LocalTime startTime;
    private LocalTime endTime;
    private DayOfWeek day;
    private int numSeatsRemaining;

    public TimedRoute(Route route, LocalTime startTime, LocalTime endTime, DayOfWeek day) {
        this.route = route;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
    }
}
