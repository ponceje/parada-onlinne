package com.onlinne.parada.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer parkingLotId;
    private String parkingLotCode;
    private double parkingRate;
    private Integer locationId;

    @OneToMany
    @JoinColumn(name = "Parking_Lot_Id")
    private List<ParkingPosition> parkingPositionList;

    public ParkingLot(){

    }

    public ParkingLot(Integer parkingLotId, String parkingLotCode) {
        this.parkingLotId = parkingLotId;
        this.parkingLotCode = parkingLotCode;
    }

    public Integer getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Integer parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getParkingLotCode() {
        return parkingLotCode;
    }

    public void setParkingLotCode(String parkingLotCode) {
        this.parkingLotCode = parkingLotCode;
    }

    public List<ParkingPosition> getParkingPositionList() {
        return parkingPositionList;
    }

    public void setParkingPositionList(List<ParkingPosition> parkingPositionList) {
        this.parkingPositionList = parkingPositionList;
    }

    public double getParkingRate() {
        return parkingRate;
    }

    public void setParkingRate(double parkingRate) {
        this.parkingRate = parkingRate;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
}
