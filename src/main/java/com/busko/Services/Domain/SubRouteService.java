package com.busko.Services.Domain;

import com.busko.Models.SubRoute;

import java.util.List;
import java.util.Optional;

public interface SubRouteService {
    List<SubRoute> getAllSubRoutes();
    Optional<SubRoute> getSubRouteById(Long id);
    SubRoute createSubRoute(SubRoute subRoute);
    Optional<SubRoute> updateSubRoute(Long id, SubRoute subRoute);
    Optional<SubRoute> deleteSubRoute(Long id);

}
