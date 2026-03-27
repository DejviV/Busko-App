package com.busko.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class SubRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ID;
    private String RouteID;
    private String CompanyID;
    private String StartingPoint;
    private String EndPoint;
    private double Price;

    public SubRoute() {}

    public SubRoute(String routeID, String companyID, String startingPoint, String endPoint, double price) {
        this.RouteID = routeID;
        this.CompanyID = companyID;
        this.StartingPoint = startingPoint;
        this.EndPoint = endPoint;
        this.Price = price;
    }
}
