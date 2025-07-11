package com.parkinglot.vehicle;

import com.parkinglot.enums.ParkingSpotType;
import com.parkinglot.enums.VehicleType;
import com.parkinglot.tikcet.ParkingTicket;

public class Van extends Vehicle{

    public Van(String licenseNumber ){
        super(licenseNumber,VehicleType.VAN);
    }
    @Override
    public void assignParkingTicket(ParkingTicket parkingTicket) {
        super.setParkingTicket(parkingTicket);
    }
}
