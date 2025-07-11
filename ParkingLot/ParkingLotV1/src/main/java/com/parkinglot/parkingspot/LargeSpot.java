package com.parkinglot.parkingspot;

import com.parkinglot.enums.ParkingSpotType;
import com.parkinglot.vehicle.Vehicle;

public class LargeSpot  extends ParkingSpot{

    public LargeSpot(String parkingSpotId) {
        super(parkingSpotId, ParkingSpotType.LARGE);
    }

    @Override
    public boolean assignVehicleToSpot(Vehicle vehicle) {
        if(! isSpotAvailable()) return false;
        setVehicle(vehicle);
        return true;
    }
}
