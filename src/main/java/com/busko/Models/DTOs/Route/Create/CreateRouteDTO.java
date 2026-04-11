package com.busko.Models.DTOs.Route.Create;

import com.busko.Models.BusStop;
import com.busko.Models.Route;
import com.busko.Models.User;

public record CreateRouteDTO(
        Long companyId,
        Long startingPointId,
        Long endingPointId,
        int numSeats
) {
    public Route toRoute(User company, BusStop startingBusStop, BusStop endingBusStop) {
        return new Route(
                company,
                startingBusStop,
                endingBusStop,
                numSeats
        );
    }
}
