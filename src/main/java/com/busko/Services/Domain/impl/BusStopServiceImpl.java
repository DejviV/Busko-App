package com.busko.Services.Domain.impl;

import com.busko.Models.BusStop;
import com.busko.Repository.BusStopRepository;
import com.busko.Services.Domain.BusStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusStopServiceImpl implements BusStopService {

    private final BusStopRepository busStopRepository;
    @Autowired
    public BusStopServiceImpl(BusStopRepository busStopRepository) {
        this.busStopRepository = busStopRepository;
    }
    @Override
    public List<BusStop> getAllBusStops() {
        return busStopRepository.findAll();
    }

    @Override
    public Optional<BusStop> getBusStopById(Long id) {
        return busStopRepository.findById(id);
    }

    @Override
    public BusStop createBusStop(BusStop busStop) {
        return busStopRepository.save(busStop);
    }

    @Override
    public Optional<BusStop> updateBusStop(Long id, BusStop busStop) {
        return busStopRepository.findById(id).map(existingbusStop ->{
            existingbusStop.setName(busStop.getName());
            return busStopRepository.save(existingbusStop);
        });
    }

    @Override
    public Optional<BusStop> deleteBusStop(Long id) {

        Optional<BusStop> busStop = busStopRepository.findById(id);
        busStop.ifPresent(busStopRepository::delete);
        return busStop;
    }
}
