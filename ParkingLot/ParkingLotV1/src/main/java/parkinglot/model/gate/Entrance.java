package parkinglot.model.gate;

import parkinglot.enums.ParkingSpotType;
import parkinglot.system.ParkingLot;
import parkinglot.ticket.ParkingTicket;
import parkinglot.vehicle.Vehicle;

public class Entrance {
    private final String id;
    private final ParkingLot parkingLot;

    public Entrance(String id, ParkingLot parkingLot) {
        this.id = id;
        this.parkingLot = parkingLot;
    }

    public String getId() {
        return id;
    }

    // ✅ Check if parking is available for the vehicle type
    public boolean checkAvailability(Vehicle vehicle) {
        ParkingSpotType type = vehicle.getType();
        return !parkingLot.isFull(type);
    }

    // ✅ Get parking ticket for the vehicle
    public ParkingTicket getParkingTicket(Vehicle vehicle) {
        return parkingLot.getParkingTicket(vehicle);
    }
}
