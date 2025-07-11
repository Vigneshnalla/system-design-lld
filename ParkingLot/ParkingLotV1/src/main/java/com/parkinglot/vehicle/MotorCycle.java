package com.parkinglot.vehicle;

import com.parkinglot.enums.ParkingSpotType;
import com.parkinglot.enums.VehicleType;
import com.parkinglot.tikcet.ParkingTicket;

public class MotorCycle extends Vehicle{
    public MotorCycle(String licenseNumber ){
        super(licenseNumber,VehicleType.MOTORCYCLE);
    }
    @Override
    public void assignParkingTicket(ParkingTicket parkingTicket) {
        super.setParkingTicket(parkingTicket);
    }
}
