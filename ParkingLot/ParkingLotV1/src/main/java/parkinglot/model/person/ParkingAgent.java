package parkinglot.model.person;

import parkinglot.enums.AccountStatus;
import parkinglot.model.Address;
import parkinglot.parking.ParkingSpot;
import parkinglot.ticket.ParkingTicket;
import parkinglot.vehicle.Vehicle;

public class ParkingAgent extends Person  {

    public ParkingAgent(String userName, Address address, String phone, String email, AccountStatus accountStatus) {
        super(userName, address, phone, email, accountStatus);
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        super.setAccountStatus(accountStatus);
    }

    /**
     * Assign a parking ticket to a customer.
     */
    public void assignTicketToCustomer(Customer customer, ParkingTicket ticket) {
        if (customer.getAccountStatus() == AccountStatus.ACTIVE) {
            customer.addParkingTicket(ticket);
        }
    }

    /**
     * Mark a parking ticket as paid.
     */
    public void payTicket(ParkingTicket ticket) {
        if (ticket != null && !ticket.isPaid()) {
            ticket.markAsPaid();
        }
    }

    /**
     * Release customer's vehicle if payment is completed.
     */
    public boolean releaseVehicleForCustomer(Customer customer, ParkingSpot spot) {
        ParkingTicket ticket = customer.getActiveTicket();
        if (ticket != null && ticket.isPaid()) {
            return spot.removeVehicle();
        }
        return false;
    }

    /**
     * View the vehicle of the customer (for assistance).
     */
    public Vehicle getCustomerVehicle(Customer customer) {
        return customer.getVehicle();
    }
}
