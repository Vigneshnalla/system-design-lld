package parkinglot.parking;

import parkinglot.enums.ParkingSpotType;
import parkinglot.vehicle.Vehicle;

public class Handicapped extends ParkingSpot {

    public Handicapped(int id) {
        super(id, ParkingSpotType.HANDICAPPED);
    }

    @Override
    public boolean assignVehicleToSpot(Vehicle vehicle) {
        if (this.isSpotFree()) {
            setVehicle(vehicle); // call inherited protected method
            return true;
        }
        return false;
    }
}
