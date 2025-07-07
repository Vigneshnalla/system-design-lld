package parkinglot.vehicle;

import parkinglot.enums.ParkingSpotType;
import parkinglot.ticket.ParkingTicket;

public abstract class Vehicle {
    private int licenceNo;
    private ParkingSpotType type;
    private ParkingTicket parkingTicket;

    public Vehicle(int licenceNo, ParkingSpotType type) {
        this.licenceNo = licenceNo;
        this.type = type;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public int getLicenceNo() {
        return licenceNo;
    }
    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    protected void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }
    

    @Override
    public String toString() {
        return "Vehicle{" +
                "licenceNo=" + licenceNo +
                ", type=" + type +
                '}';
    }

    public abstract void assignTicket(ParkingTicket parkingTicket);
}
