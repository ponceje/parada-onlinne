package com.onlinne.parada.service;

import com.onlinne.parada.model.Location;
import com.onlinne.parada.model.ParkingLot;
import com.onlinne.parada.repository.LocationRepository;
import com.onlinne.parada.repository.ParkingLotRepository;
import com.onlinne.parada.repository.ParkingPositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchParkingLotService {
    private final LocationRepository locationRepository;
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingPositionRepository parkingPositionRepository;

    public SearchParkingLotService(LocationRepository locationRepository, ParkingLotRepository parkingLotRepository, ParkingPositionRepository parkingPositionRepository) {
        this.locationRepository = locationRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingPositionRepository = parkingPositionRepository;
    }

    public List<ParkingLot> searchParkingLot(String locationName) {
        List<Location> locationList = locationRepository.findByLocationName(locationName);
        List<Integer> locationIds = locationList.stream().map(Location::getLocationId).collect(Collectors.toList());
        List<ParkingLot> parkingLotsAvailable = parkingLotRepository.findAllByLocationIdIn(locationIds);
        return parkingLotsAvailable;
    }
}
