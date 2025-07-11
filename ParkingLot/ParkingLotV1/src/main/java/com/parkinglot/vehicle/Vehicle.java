package com.parkinglot.vehicle;

import com.parkinglot.enums.ParkingSpotType;
import com.parkinglot.enums.ParkingTicketStatus;
import com.parkinglot.enums.VehicleType;
import com.parkinglot.tikcet.ParkingTicket;

public abstract class Vehicle {
    private String licenceNumber;
    private ParkingTicket parkingTicket;
    private VehicleType vehicleType;

    protected Vehicle(String licenceNumber,VehicleType vehicleType){
        this.licenceNumber = licenceNumber;
        this.vehicleType = vehicleType ;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public abstract void assignParkingTicket(ParkingTicket parkingTicket);
}
