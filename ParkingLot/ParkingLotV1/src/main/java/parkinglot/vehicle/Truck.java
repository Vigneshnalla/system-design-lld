package parkinglot.vehicle;

import parkinglot.enums.ParkingSpotType;
import parkinglot.ticket.ParkingTicket;

public class Truck extends Vehicle {

    public Truck(int licenceNo) {
        super(licenceNo, ParkingSpotType.MOTORCYCLE);  // Pass appropriate type
    }
    public Truck(int licenceNo,ParkingSpotType parkingSpotType) {
        super(licenceNo, parkingSpotType);  // Pass appropriate type
    }

    public ParkingTicket getParkingTicket() {
        return super.getParkingTicket();
    }

    @Override
    public void assignTicket(ParkingTicket parkingTicket) {
        super.setParkingTicket(parkingTicket);
    }
}
