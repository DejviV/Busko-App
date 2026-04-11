package com.busko.Models.DTOs.Route.Display;

import com.busko.Models.Route;

import java.math.BigDecimal;

public record DisplayRouteDTO(
        String companyName,
        String routeName,
        int numSeats
) {
    public static DisplayRouteDTO from(Route route) {
        return new DisplayRouteDTO(
                route.getCompany().getNameAndSurname(),
                route.getName(),
                route.getNumSeats()
        );
    }
}
