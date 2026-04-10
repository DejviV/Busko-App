package com.busko.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class SubRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private Route route;
    @ManyToOne(fetch = FetchType.LAZY)
    private BusStop startingPoint;
    @ManyToOne(fetch = FetchType.LAZY)
    private BusStop endPoint;
    private BigDecimal price;


    public SubRoute(Route route, BusStop startingPoint, BusStop endPoint, BigDecimal price) {
        this.route = route;
        this.startingPoint = startingPoint;
        this.endPoint = endPoint;
        this.price = price;

    }
    public String getName() {
        return startingPoint.getName() +  " - " + endPoint.getName();
    }
}
