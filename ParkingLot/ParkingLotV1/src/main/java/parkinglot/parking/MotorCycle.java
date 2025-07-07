package parkinglot.parking;

import parkinglot.enums.ParkingSpotType;
import parkinglot.vehicle.Vehicle;

public class MotorCycle extends ParkingSpot {

    public MotorCycle(int id) {
        super(id, ParkingSpotType.MOTORCYCLE);
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
