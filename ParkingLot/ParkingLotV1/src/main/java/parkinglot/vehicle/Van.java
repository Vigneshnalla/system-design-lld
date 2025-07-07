package parkinglot.vehicle;

import parkinglot.enums.ParkingSpotType;
import parkinglot.ticket.ParkingTicket;

public class Van extends Vehicle {

    public Van(int licenceNo) {
        super(licenceNo, ParkingSpotType.MOTORCYCLE);  // Pass appropriate type
    }
    public Van(int licenceNo,ParkingSpotType parkingSpotType) {
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
