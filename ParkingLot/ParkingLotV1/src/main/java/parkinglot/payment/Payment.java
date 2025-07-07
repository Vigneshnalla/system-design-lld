package parkinglot.payment;

import parkinglot.enums.PaymentStatus;

import java.util.Date;

public abstract class Payment {
    private double amount;
    private PaymentStatus status;
    private Date timestamp;

    protected Payment(double amount) {
        this.amount = amount;
        this.timestamp = new Date(); // Set default timestamp to now
        this.status = PaymentStatus.PENDING; // Default status
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    protected void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    protected void setStatus(PaymentStatus status) {
        this.status = status;
    }

    // All payment types will define their own logic
    public abstract boolean initiateTransaction();
}
