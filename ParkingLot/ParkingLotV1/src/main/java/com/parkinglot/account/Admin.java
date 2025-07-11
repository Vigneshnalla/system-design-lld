package com.parkinglot.account;

import com.parkinglot.enums.AccountStatus;
import com.parkinglot.user.Person;

public class Admin extends Account {

    public Admin(String userName, String password, Person person) {
        super(userName, password, person, AccountStatus.ACTIVE);
    }

    @Override
    public void resetPassword(String newPassword) {
        super.setPassword(newPassword);
    }

    // You can add Admin-specific functionality here if needed
}
