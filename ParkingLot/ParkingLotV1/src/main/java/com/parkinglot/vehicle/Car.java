package com.parkinglot.vehicle;

import com.parkinglot.enums.ParkingSpotType;
import com.parkinglot.enums.VehicleType;
import com.parkinglot.tikcet.ParkingTicket;

public class Car extends Vehicle {

    public Car(String licenseNumber){
        super(licenseNumber,VehicleType.CAR);
    }
    @Override
    public void assignParkingTicket(ParkingTicket parkingTicket) {
        super.setParkingTicket(parkingTicket);
    }
}
