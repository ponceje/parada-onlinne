package com.onlinne.parada.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locationId;
    private String locationCode;
    private String locationName;

    @OneToMany
    @JoinColumn(name = "Location_Id")
    private List<ParkingLot> parkingLotList;

    public Location() {
    }

    public Location(Integer locationId, String locationCode, String locationName) {
        this.locationId = locationId;
        this.locationCode = locationCode;
        this.locationName = locationName;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }
}

