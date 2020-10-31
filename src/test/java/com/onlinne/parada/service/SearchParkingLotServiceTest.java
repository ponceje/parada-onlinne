package com.onlinne.parada.service;

import com.onlinne.parada.model.Location;
import com.onlinne.parada.model.ParkingLot;
import com.onlinne.parada.repository.LocationRepository;
import com.onlinne.parada.repository.ParkingLotRepository;
import com.onlinne.parada.repository.ParkingPositionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class SearchParkingLotServiceTest {
    LocationRepository locationRepository;
    ParkingLotRepository parkingLotRepository;
    ParkingPositionRepository parkingPositionRepository;
    SearchParkingLotService service;

    @BeforeEach
    void setUp() {
        locationRepository = Mockito.mock(LocationRepository.class);
        parkingLotRepository = Mockito.mock(ParkingLotRepository.class);
        parkingPositionRepository = Mockito.mock(ParkingPositionRepository.class);
        service = new SearchParkingLotService(locationRepository, parkingLotRepository, parkingPositionRepository);
    }

    @Test
    void should_get_all_parking_lots_when_search_given_location() {
        //Given
        String locationName = "Glorietta";
        Location location = new Location(1, "G1", "Glorietta1");
        Location location2 = new Location(2, "G2", "Glorietta2");
        Location location3 = new Location(3, "G3", "Glorietta3");

        List<Location> locationList = asList(location, location2, location3);
        List<ParkingLot> parkingLotList = asList(
                new ParkingLot(1, "111"),
                new ParkingLot(2, "222"),
                new ParkingLot(2, "333")
        );

        //When
        when(locationRepository.findByLocationName(locationName)).thenReturn(locationList);
        List<Integer> locationIds = locationList.stream().map(location1 -> location.getLocationId()).collect(Collectors.toList());

        when(parkingLotRepository.findAllById(locationIds)).thenReturn(parkingLotList);

        List<ParkingLot> parkingLotsAvailable = service.searchParkingLot(locationName);


        //Then
        assertEquals(parkingLotList, parkingLotsAvailable);


    }
}