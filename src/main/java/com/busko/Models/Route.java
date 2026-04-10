package com.busko.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private User company;

    @ManyToOne(fetch = FetchType.LAZY)
    private BusStop startingPoint;
    @ManyToOne(fetch = FetchType.LAZY)
    private BusStop endPoint;

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    private List<SubRoute> subRoutes = new ArrayList<>();
    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    private List<TimedRoute> timedRoutes = new ArrayList<>();

    private int numSeats;



    public Route(User company, BusStop startingPoint, BusStop endPoint, int numSeats) {
        this.company = company;
        this.startingPoint = startingPoint;
        this.endPoint = endPoint;
        this.numSeats = numSeats;

    }
    public String getName() {
        return startingPoint.getName() +  " - " + endPoint.getName();
    }
}
