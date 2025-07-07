package parkinglot.vehicle;

import parkinglot.enums.ParkingSpotType;
import parkinglot.ticket.ParkingTicket;

public class MotorCycle extends Vehicle {

    public MotorCycle(int licenceNo) {
        super(licenceNo, ParkingSpotType.MOTORCYCLE);  // Pass appropriate type
    }
    public MotorCycle(int licenceNo,ParkingSpotType parkingSpotType) {
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
