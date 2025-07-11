package com.parkinglot.parkingspot;

import com.parkinglot.enums.ParkingSpotType;
import com.parkinglot.vehicle.Vehicle;

public class CompactSpot extends ParkingSpot{

    public CompactSpot(String parkingSpotId) {
        super(parkingSpotId, ParkingSpotType.COMPACT);
    }

    @Override
    public boolean assignVehicleToSpot(Vehicle vehicle) {
        if(! isSpotAvailable()) return false;
        setVehicle(vehicle);
        return true;
    }
}
