package com.busko.Models.DTOs.Route.Create;

import com.busko.Models.Route;
import com.busko.Models.TimedRoute;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record CreateTimedRouteDTO(
        Long routeId,
        LocalTime startTime,
        LocalTime endTime,
        DayOfWeek day
) {
    public TimedRoute toTimedRoute(Route route) {
        return new TimedRoute(route,
                startTime,
                endTime,
                day
        );
    }
}
