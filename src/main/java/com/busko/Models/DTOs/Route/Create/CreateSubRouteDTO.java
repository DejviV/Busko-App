package com.busko.Models.DTOs.Route.Create;

import com.busko.Models.BusStop;
import com.busko.Models.Route;
import com.busko.Models.SubRoute;

import java.math.BigDecimal;

public record CreateSubRouteDTO(
        Long routeId,
        Long startingPointId,
        Long endPointId,
        BigDecimal price
) {
    public SubRoute toSubRoute(Route route, BusStop startingBusStop, BusStop endingBusStop) {
        return new SubRoute(
                route,
                startingBusStop,
                endingBusStop,
                price
        );
    }
}
