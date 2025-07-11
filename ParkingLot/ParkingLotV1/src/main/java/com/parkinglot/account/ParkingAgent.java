package com.parkinglot.account;

import com.parkinglot.enums.AccountStatus;
import com.parkinglot.user.Person;

public class ParkingAgent extends Account {

        public ParkingAgent(String userName, String password, Person person) {
            super(userName, password, person, AccountStatus.ACTIVE);
        }

        @Override
        public void resetPassword(String newPassword) {
            super.setPassword(newPassword);
        }
}