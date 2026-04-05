package com.busko.Services.Domain;

import com.busko.Models.BusStop;

import java.util.List;
import java.util.Optional;

public interface BusStopService {
    List<BusStop> getAllBusStops();
    Optional<BusStop> getBusStopById(Long id);
    BusStop createBusStop(BusStop busStop);
    Optional<BusStop> updateBusStop(Long id, BusStop busStop);
    Optional<BusStop> deleteBusStop(Long id);
}
