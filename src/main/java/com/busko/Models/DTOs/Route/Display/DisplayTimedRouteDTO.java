package com.busko.Models.DTOs.Route.Display;

import com.busko.Models.TimedRoute;

public record DisplayTimedRouteDTO(
        String companyName,
        String routeName,
        int numSeatsRemaining
) {
    public static DisplayTimedRouteDTO from(TimedRoute timedRoute) {
        return new DisplayTimedRouteDTO(
                timedRoute.getRoute().getCompany().getNameAndSurname(),
                timedRoute.getRoute().getName(),
                timedRoute.getNumSeatsRemaining()
        );
    }
}
