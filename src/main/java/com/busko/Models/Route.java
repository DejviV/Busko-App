package com.busko.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private User company;
    private String startingPoint;
    private String endPoint;
    private int numSeats;

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    private List<SubRoute> subRoutes = new ArrayList<>();
    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    private List<TimedRoute> timedRoutes = new ArrayList<>();


    public Route() {}

    public Route(User company, String startingPoint, String endPoint, int numSeats) {
        this.company = company;
        this.startingPoint = startingPoint;
        this.endPoint = endPoint;
        this.numSeats = numSeats;

    }
    public String getName() {
        return startingPoint +  " - " + endPoint;
    }
}
