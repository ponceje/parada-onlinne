package com.onlinne.parada.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParkingPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer positionId;
    private String positionCode;

    public ParkingPosition() {
    }

    public ParkingPosition(Integer positionId, String positionCode) {
        this.positionId = positionId;
        this.positionCode = positionCode;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }
}
