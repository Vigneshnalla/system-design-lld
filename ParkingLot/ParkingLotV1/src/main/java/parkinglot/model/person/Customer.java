package parkinglot.model.person;

import parkinglot.enums.AccountStatus;
import parkinglot.model.Address;
import parkinglot.ticket.ParkingTicket;
import parkinglot.vehicle.Vehicle;

public class Customer extends Person {

    private Vehicle vehicle;
    private ParkingTicket parkingTicket;

    public Customer(String userName, Address address, String phone, String email,
                    AccountStatus accountStatus, Vehicle vehicle) {
        super(userName, address, phone, email, accountStatus);
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public ParkingTicket getActiveTicket() {
        return this.parkingTicket;
    }

    public void setStatus(AccountStatus status) {
        super.setAccountStatus(status);
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void addParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    /**
     * Allows the customer to pay their parking ticket on their own.
     */
    public void payTicket() {
        if (this.parkingTicket != null && !this.parkingTicket.isPaid()) {
            this.parkingTicket.markAsPaid();
        }
    }
}
