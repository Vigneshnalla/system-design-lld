package parkinglot.model.account;

import parkinglot.enums.AccountStatus;
import parkinglot.model.person.Person;

public class Admin extends Account {

    public Admin(int id, String userName, String password, Person person) {
        super(id, userName, password, person);
        setStatus(AccountStatus.ACTIVE); // Optional: set status on creation
    }

    @Override
    public boolean resetPassword() {
        updatePassword("default123"); // Simulate password reset
        return true;
    }

    // Admin doesn't directly perform system-level actions like adding entrances, exits, etc.
    // That responsibility is handled by a central ParkingLotSystem class.
}
