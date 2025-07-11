package com.parkinglot.parkingspot;

import com.parkinglot.enums.ParkingSpotType;
import com.parkinglot.vehicle.Vehicle;

public class MotorCycleSpot extends ParkingSpot{

    public MotorCycleSpot(String parkingSpotId) {
        super(parkingSpotId, ParkingSpotType.MOTORCYCLE);
    }

    @Override
    public boolean assignVehicleToSpot(Vehicle vehicle) {
        if(! isSpotAvailable()) return false;
        setVehicle(vehicle);
        return true;
    }
}

