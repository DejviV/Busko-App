package com.busko.Services.Domain;
import com.busko.Models.Route;

import java.util.List;
import java.util.Optional;

public interface RouteService {
    List<Route> getAllRoutes();
    Optional<Route> getRouteById(Long id);
    Route saveRoute(Route route);
    Optional<Route> updateRoute(Route route);
    Optional<Route> deleteRouteById(Long id);
}
