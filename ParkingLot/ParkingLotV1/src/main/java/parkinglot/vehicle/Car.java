package parkinglot.vehicle;

import parkinglot.enums.ParkingSpotType;
import parkinglot.ticket.ParkingTicket;

public class Car extends Vehicle {

    public Car(int licenceNo) {
        super(licenceNo, ParkingSpotType.COMPACT); // Default spot type
    }

    public Car(int licenceNo, ParkingSpotType parkingSpotType) {
        super(licenceNo, parkingSpotType);
    }

    @Override
    public void assignTicket(ParkingTicket parkingTicket) {
        super.setParkingTicket(parkingTicket); // Assuming `protected` or use setter
    }

    public ParkingTicket getParkingTicket() {
        return super.getParkingTicket();
    }
}
