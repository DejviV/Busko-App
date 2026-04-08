package com.busko.Services.Domain;

import com.busko.Models.TimedRoute;

import java.util.List;
import java.util.Optional;

public interface TimedRouteService {
    List<TimedRoute> getAllTimedRoutes();
    Optional<TimedRoute> getTimedRouteById(Long id);
    TimedRoute createTimedRoute(Long routeId, TimedRoute timedRoute);
    Optional<TimedRoute> updateTimedRoute(Long id, TimedRoute timedRoute);
    Optional<TimedRoute> deleteTimedRoute(Long id);
}
