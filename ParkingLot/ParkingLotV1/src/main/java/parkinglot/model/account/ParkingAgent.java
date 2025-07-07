package parkinglot.model.account;

import parkinglot.enums.AccountStatus;
import parkinglot.model.person.Person;

public class ParkingAgent extends Account {

    public ParkingAgent(int id, String userName, String password, Person person) {
        super(id, userName, password, person);
        setStatus(AccountStatus.ACTIVE); // Optional default
    }

    @Override
    public boolean resetPassword() {
        updatePassword("default123"); // Simulate agent password reset
        return true;
    }

    // Ticket processing, payment, and vehicle release should be handled through a service class
    // like ParkingLotSystem or TicketService to follow clean design principles.
}
