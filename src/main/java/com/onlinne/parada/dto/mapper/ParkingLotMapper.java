package com.onlinne.parada.dto.mapper;

import com.onlinne.parada.dto.response.ParkingLotResponse;
import com.onlinne.parada.model.ParkingLot;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ParkingLotMapper {

    ParkingLotMapper PARKING_LOT_MAPPER = Mappers.getMapper(ParkingLotMapper.class);

    ParkingLotResponse toResponse(ParkingLot parkingLot);

    List<ParkingLotResponse> toResponse(List<ParkingLot> parkingLotList);

}