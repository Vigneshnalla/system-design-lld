package com.parkinglot.account;


import com.parkinglot.enums.AccountStatus;
import com.parkinglot.user.Person;

public abstract class Account {
    private String userName;
    private String password;
    private AccountStatus status;
    private Person person;

    public Account(String userName, String password, Person person, AccountStatus status) {
        this.userName = userName;
        this.password = password;
        this.person = person;
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public abstract void resetPassword(String newPassword) ;

}
