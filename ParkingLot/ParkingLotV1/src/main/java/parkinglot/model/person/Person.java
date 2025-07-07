package parkinglot.model.person;

import parkinglot.enums.AccountStatus;
import parkinglot.model.Address;

public abstract class Person {
    private AccountStatus accountStatus;
    private String userName;
    private Address address;
    private String phone;
    private String email;

    protected Person(String userName, Address address, String phone, String email, AccountStatus accountStatus) {
        this.userName = userName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.accountStatus = accountStatus;
    }

    public String getUserName() {
        return userName;
    }

    protected void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getAddress() {
        return address;
    }

    protected void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    protected void setPhone(String phone) {
        this.phone = phone;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    protected void setAccountStatus(AccountStatus status) {
        this.accountStatus = status;
    }

    public String getEmail() {
        return email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }
}
