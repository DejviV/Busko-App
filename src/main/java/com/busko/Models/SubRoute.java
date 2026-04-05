package com.busko.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SubRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private Route route;
    private String startingPoint;
    private String endPoint;
    private double price;

    public SubRoute() {}

    public SubRoute(Route route, String startingPoint, String endPoint, double price) {
        this.route = route;
        this.startingPoint = startingPoint;
        this.endPoint = endPoint;
        this.price = price;
    }
}
