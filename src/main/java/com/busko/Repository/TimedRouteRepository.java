package com.busko.Repository;

import com.busko.Models.TimedRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimedRouteRepository extends JpaRepository<TimedRoute, Long> {
}
