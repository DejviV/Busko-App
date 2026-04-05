package com.busko.Services.Domain.impl;

import com.busko.Models.TimedRoute;
import com.busko.Repository.TimedRouteRepository;
import com.busko.Services.Domain.TimedRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimedRouteServiceImpl implements TimedRouteService {

    private final TimedRouteRepository timedRouteRepository;

    @Autowired
    public TimedRouteServiceImpl(TimedRouteRepository timedRouteRepository) {
        this.timedRouteRepository = timedRouteRepository;
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
    public TimedRoute createTimedRoute(TimedRoute timedRoute) {
        return timedRouteRepository.save(timedRoute);
    }

    @Override
    public Optional<TimedRoute> updateTimedRoute(Long id, TimedRoute timedRoute) {
        return timedRouteRepository.findById(id).map(existingTimedRoute -> {
            existingTimedRoute.setStartTime(timedRoute.getStartTime());
            existingTimedRoute.setEndTime(timedRoute.getEndTime());
            existingTimedRoute.setDay(timedRoute.getDay());
            existingTimedRoute.setDate(timedRoute.getDate());
            existingTimedRoute.setNumSeats(timedRoute.getNumSeats());
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