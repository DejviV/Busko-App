package com.busko.Services.Domain.impl;

import com.busko.Models.Route;
import com.busko.Models.SubRoute;
import com.busko.Repository.RouteRepository;
import com.busko.Repository.SubRouteRepository;
import com.busko.Services.Domain.SubRouteService;

import java.util.List;
import java.util.Optional;

public class SubRouteServiceImpl implements SubRouteService {

    private final SubRouteRepository subRouteRepository;
    private final RouteRepository routeRepository;

    public SubRouteServiceImpl(SubRouteRepository subRouteRepository,  RouteRepository routeRepository) {
        this.subRouteRepository = subRouteRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public List<SubRoute> getAllSubRoutes() {
        return subRouteRepository.findAll();
    }

    @Override
    public Optional<SubRoute> getSubRouteById(Long id) {
        return subRouteRepository.findById(id);
    }

    @Override
    public SubRoute createSubRoute(Long routeId, SubRoute subRoute) {
        Route route = routeRepository.findById(routeId).get();
        subRoute.setRoute(route);
        return subRouteRepository.save(subRoute);
    }

    @Override
    public Optional<SubRoute> updateSubRoute(Long id, SubRoute subRoute) {
        return subRouteRepository.findById(id).map(existingSubRoute -> {
            existingSubRoute.setStartingPoint(subRoute.getStartingPoint());
            existingSubRoute.setEndPoint(subRoute.getEndPoint());
            existingSubRoute.setPrice(subRoute.getPrice());
            return subRouteRepository.save(existingSubRoute);
        });
    }

    @Override
    public Optional<SubRoute> deleteSubRoute(Long id) {
        return subRouteRepository.findById(id).map(subRoute -> {
            subRouteRepository.delete(subRoute);
            return subRoute;
        });
    }
}
