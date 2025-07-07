package parkinglot.model.account;

import parkinglot.enums.AccountStatus;
import parkinglot.model.person.Person;

public abstract class Account {
    private int id;
    private String userName;
    private String password;
    private Person person;
    private AccountStatus status;

    protected Account(int id, String userName, String password, Person person) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.person = person;
        this.status = AccountStatus.CREATED; // optional default
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    protected Person getPerson() {
        return this.person;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    protected void updatePassword(String password) {
        this.password = password;
    }

    public abstract boolean resetPassword();
}
