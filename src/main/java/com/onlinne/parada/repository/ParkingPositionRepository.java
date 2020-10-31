package com.onlinne.parada.repository;

import com.onlinne.parada.model.ParkingPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingPositionRepository extends JpaRepository<ParkingPosition, Integer> {
}
