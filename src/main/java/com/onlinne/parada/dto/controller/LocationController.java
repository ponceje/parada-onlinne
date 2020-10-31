package com.onlinne.parada.dto.controller;

import com.onlinne.parada.dto.response.ParkingLotResponse;
import com.onlinne.parada.model.ParkingLot;
import com.onlinne.parada.service.SearchParkingLotService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.onlinne.parada.dto.mapper.ParkingLotMapper.PARKING_LOT_MAPPER;

@RestController
@RequestMapping("/parada")
public class LocationController {
    private SearchParkingLotService searchParkingLotService;

    public LocationController(SearchParkingLotService searchParkingLotService) {
        this.searchParkingLotService = searchParkingLotService;
    }

    @GetMapping("/search/{name}")
    public List<ParkingLotResponse> search(@PathVariable String name) {
        return PARKING_LOT_MAPPER.toResponse(searchParkingLotService.searchParkingLot(name));
    }
}
