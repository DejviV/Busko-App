package com.busko.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
public class SubRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private Route route;
    private String startingPoint;
    private String endPoint;
    private BigDecimal price;


    public SubRoute(Route route, String startingPoint, String endPoint, BigDecimal price) {
        this.route = route;
        this.startingPoint = startingPoint;
        this.endPoint = endPoint;
        this.price = price;

    }
    public String getName() {
        return startingPoint +  " - " + endPoint;
    }
}
