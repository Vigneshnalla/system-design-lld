package parkinglot.payment;

import parkinglot.enums.PaymentStatus;

import java.util.Date;

public class CashPayment extends Payment {
    public CashPayment(double amount) {
        super(amount);
    }

    @Override
    public boolean initiateTransaction() {
        // In real systems, maybe just confirm manual payment
        setStatus(PaymentStatus.COMPLETED);
        setTimestamp(new Date());
        return true;
    }
}

