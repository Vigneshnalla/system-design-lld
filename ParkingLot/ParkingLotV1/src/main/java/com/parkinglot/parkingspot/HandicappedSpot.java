package com.parkinglot.parkingspot;

import com.parkinglot.enums.ParkingSpotType;
import com.parkinglot.vehicle.Vehicle;

public class HandicappedSpot extends ParkingSpot{

    public HandicappedSpot(String parkingSpotId) {
        super(parkingSpotId, ParkingSpotType.HANDICAPPED);
    }

    @Override
    public boolean assignVehicleToSpot(Vehicle vehicle) {
        if(! isSpotAvailable()) return false;
        setVehicle(vehicle);
        return true;
    }
}
