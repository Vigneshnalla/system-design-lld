package parkinglot.parking;

import parkinglot.enums.ParkingSpotType;
import parkinglot.vehicle.Vehicle;

public class Compact extends ParkingSpot {

    public Compact(int id) {
        super(id, ParkingSpotType.COMPACT);
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
