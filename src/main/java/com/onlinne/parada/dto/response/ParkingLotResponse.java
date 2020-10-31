package com.onlinne.parada.dto.response;

public class ParkingLotResponse {
    private String parkingLotCode;
    private double parkingRate;

    public ParkingLotResponse() {
    }

    public ParkingLotResponse(String parkingLotCode, double parkingRate) {
        this.parkingLotCode = parkingLotCode;
        this.parkingRate = parkingRate;
    }

    public String getParkingLotCode() {
        return parkingLotCode;
    }

    public void setParkingLotCode(String parkingLotCode) {
        this.parkingLotCode = parkingLotCode;
    }

    public double getParkingRate() {
        return parkingRate;
    }

    public void setParkingRate(double parkingRate) {
        this.parkingRate = parkingRate;
    }
}
