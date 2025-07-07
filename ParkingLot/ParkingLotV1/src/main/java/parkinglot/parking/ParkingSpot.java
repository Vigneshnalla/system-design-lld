package parkinglot.parking;

import parkinglot.enums.ParkingSpotType;
import parkinglot.vehicle.Vehicle;

public abstract class ParkingSpot {
    private final int parkingSpotId;
    private Vehicle vehicle;
    private boolean isSpotAvailable;
    private final ParkingSpotType parkingSpotType;

    public ParkingSpot(int parkingSpotId, ParkingSpotType parkingSpotType) {
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotType = parkingSpotType;
        this.isSpotAvailable = true;
    }

    public boolean isSpotFree() {
        return isSpotAvailable;
    }

    public int getParkingSpotId() {
        return parkingSpotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void vacateVehicleFromSpot() {
        this.vehicle = null;
        this.isSpotAvailable = true;
    }
    protected void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isSpotAvailable = false;
    }

    public abstract boolean assignVehicleToSpot(Vehicle vehicle);
}
