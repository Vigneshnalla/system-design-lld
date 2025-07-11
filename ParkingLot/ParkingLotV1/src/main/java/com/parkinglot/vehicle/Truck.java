package com.parkinglot.vehicle;

import com.parkinglot.enums.ParkingSpotType;
import com.parkinglot.enums.VehicleType;
import com.parkinglot.tikcet.ParkingTicket;

public class Truck extends Vehicle{
    public Truck(String licenseNumber ){
        super(licenseNumber,VehicleType.TRUCK);
    }
    @Override
    public void assignParkingTicket(ParkingTicket parkingTicket) {
        super.setParkingTicket(parkingTicket);
    }
}

