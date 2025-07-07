package parkinglot.parking;

import parkinglot.enums.ParkingSpotType;
import parkinglot.vehicle.Vehicle;

public class Large extends ParkingSpot {

    public Large(int id) {
        super(id, ParkingSpotType.LARGE);
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
