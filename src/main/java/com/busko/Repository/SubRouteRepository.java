package com.busko.Repository;

import com.busko.Models.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubRouteRepository extends CrudRepository<Route, String> {
}
