package com.busko.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private Long CompanyID;
    private String StartingPoint;
    private String EndPoint;
    private int NumSeats;


    public Route() {}

    public Route(Long companyID, String startingPoint, String endPoint, int numSeats) {
        this.CompanyID = companyID;
        this.StartingPoint = startingPoint;
        this.EndPoint = endPoint;
        this.NumSeats = numSeats;
    }
}
