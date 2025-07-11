package com.parkinglot.parkingspot;

import com.parkinglot.enums.ParkingSpotType;
import com.parkinglot.vehicle.Vehicle;

public abstract class ParkingSpot {
    private final String parkingSpotId;
    private Vehicle vehicle;
    protected boolean isSpotAvailable;
    private ParkingSpotType parkingSpotType;

    protected ParkingSpot(String parkingSpotId,ParkingSpotType parkingSpotType){
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotType = parkingSpotType;
        this.isSpotAvailable = true;
        this.vehicle = null;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType){
        this.parkingSpotType = parkingSpotType;
    }


    public abstract boolean assignVehicleToSpot(Vehicle vehicle);

    public void vacateVehicleFromSpot(){
        this.vehicle = null;
        this.isSpotAvailable = true;
    }


    protected void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isSpotAvailable = false;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isSpotAvailable() {
        return isSpotAvailable;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

}
