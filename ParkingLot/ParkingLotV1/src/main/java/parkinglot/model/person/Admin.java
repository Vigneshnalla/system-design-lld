package parkinglot.model.person;

import parkinglot.enums.AccountStatus;
import parkinglot.model.Address;
import parkinglot.model.gate.Entrance;
import parkinglot.model.gate.Exit;
import parkinglot.parking.ParkingSpot;
import parkinglot.pricing.PricingPolicy;
import parkinglot.system.ParkingLotSystem;

public class Admin extends Person {

    public Admin(String userName, Address address, String phone, String email, AccountStatus accountStatus) {
        super(userName, address, phone, email, accountStatus);
    }

    public void addEntrance(Entrance entrance) {
//        ParkingLotSystem.addEntrance(entrance);
    }

    public void addExit(Exit exit) {
//        ParkingLotSystem.addExit(exit);
    }

    public void modifyPricingRate(PricingPolicy pricingPolicy) {
//        ParkingLotSystem.modifyPricingRate(pricingPolicy);
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
//        ParkingLotSystem.addParkingSpot(parkingSpot);
    }
}
