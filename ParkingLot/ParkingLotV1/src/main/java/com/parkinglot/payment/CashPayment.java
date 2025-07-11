package com.parkinglot.payment;

import com.parkinglot.enums.PaymentStatus;
import com.parkinglot.enums.PaymentType;

public class CashPayment extends Payment {
    private double cashReceived;
    private double changeReturned;

    public CashPayment(double amount, double cashReceived) {
        super(amount);
        this.cashReceived = cashReceived;
        this.changeReturned = Math.max(0, cashReceived - amount);
    }

    @Override
    public PaymentInfo initiateTransaction() {
        if (cashReceived >= getAmount()) {
            super.setPaymentStatus(PaymentStatus.COMPLETED);
        } else {
            setPaymentStatus(PaymentStatus.FAILED);
            changeReturned = 0;
        }

        return new PaymentInfo(
                transactionId,
                amount,
                paymentStatus,
                PaymentType.CASH
        );
    }

    public double getCashReceived() {
        return cashReceived;
    }

    public double getChangeReturned() {
        return changeReturned;
    }
}
