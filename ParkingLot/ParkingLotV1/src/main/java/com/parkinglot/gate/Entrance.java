package com.parkinglot.gate;

import com.parkinglot.ParkingLot;
import com.parkinglot.parkingspot.ParkingSpot;
import com.parkinglot.tikcet.ParkingTicket;
import com.parkinglot.vehicle.Vehicle;

public class Entrance {
    private final String entranceId;
    private final ParkingLot parkingLot;

    public Entrance(String entranceId) {
        this.entranceId = entranceId;
        this.parkingLot = ParkingLot.getInstance();
    }

    public String getEntranceId() {
        return entranceId;
    }

    public ParkingTicket getNewParkingTicket(Vehicle vehicle) {
        return parkingLot.getNewParkingTicket(vehicle);
    }
}
