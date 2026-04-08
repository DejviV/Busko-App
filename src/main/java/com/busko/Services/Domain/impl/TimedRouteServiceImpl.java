package com.busko.Services.Domain.impl;

import com.busko.Models.Route;
import com.busko.Models.TimedRoute;
import com.busko.Repository.RouteRepository;
import com.busko.Repository.TimedRouteRepository;
import com.busko.Services.Domain.TimedRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimedRouteServiceImpl implements TimedRouteService {

    private final TimedRouteRepository timedRouteRepository;
    private final RouteRepository routeRepository;


    public TimedRouteServiceImpl(TimedRouteRepository timedRouteRepository, RouteRepository routeRepository) {
        this.timedRouteRepository = timedRouteRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public List<TimedRoute> getAllTimedRoutes() {
        return timedRouteRepository.findAll();
    }

    @Override
    public Optional<TimedRoute> getTimedRouteById(Long id) {
        return timedRouteRepository.findById(id);
    }

    @Override
    public TimedRoute createTimedRoute(Long routeId, TimedRoute timedRoute) {
        Route route = routeRepository.findById(routeId).get();
        timedRoute.setRoute(route);
        return timedRouteRepository.save(timedRoute);
    }

    @Override
    public Optional<TimedRoute> updateTimedRoute(Long id, TimedRoute timedRoute) {
        return timedRouteRepository.findById(id).map(existingTimedRoute -> {
            existingTimedRoute.setStartTime(timedRoute.getStartTime());
            existingTimedRoute.setEndTime(timedRoute.getEndTime());
            existingTimedRoute.setDay(timedRoute.getDay());
            existingTimedRoute.setNumSeatsRemaining(timedRoute.getNumSeatsRemaining());
            return existingTimedRoute;
        });
    }

    @Override
    public Optional<TimedRoute> deleteTimedRoute(Long id) {
        Optional<TimedRoute> timedRoute = timedRouteRepository.findById(id);
        timedRoute.ifPresent(timedRouteRepository::delete);
        return timedRoute;
    }



}