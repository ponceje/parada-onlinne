package com.onlinne.parada.repository;

import com.onlinne.parada.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer> {
    List<ParkingLot> findAllByLocationIdIn(List<Integer> locationIds);
}
