package com.busko.Services.Domain.impl;

import com.busko.Models.Route;
import com.busko.Repository.RouteRepository;
import com.busko.Services.Domain.RouteService;

import java.util.List;
import java.util.Optional;

public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public Optional<Route> getRouteById(Long id) {
        return routeRepository.findById(id);
    }

    @Override
    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Optional<Route> updateRoute(Long id, Route route) {
        return routeRepository.findById(id).map(existingRoute -> {
            existingRoute.setStartingPoint(route.getStartingPoint());
            existingRoute.setEndPoint(route.getEndPoint());
            existingRoute.setNumSeats(route.getNumSeats());
            return routeRepository.save(existingRoute);
        });

    }

    @Override
    public Optional<Route> deleteRouteById(Long id) {
        return Optional.empty();
    }
}
