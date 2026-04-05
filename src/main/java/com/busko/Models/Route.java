package com.busko.Models;

import jakarta.persistence.*;
import lombok.Data;

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


    public Route() {}

    public Route(User company, String startingPoint, String endPoint, int numSeats) {
        this.company = company;
        this.startingPoint = startingPoint;
        this.endPoint = endPoint;
        this.numSeats = numSeats;

    }
}
