package com.parkinglot.payment;

import com.parkinglot.enums.PaymentStatus;
import com.parkinglot.enums.PaymentType;
import com.parkinglot.tikcet.ParkingTicket;

import java.util.Date;
import java.util.UUID;

import static com.parkinglot.enums.PaymentType;
import static com.parkinglot.enums.PaymentType.CARD;
import static com.parkinglot.enums.PaymentType.CASH;

public abstract class Payment {
    protected String transactionId;
    protected Date creationDate;
    protected double amount;
    protected PaymentStatus paymentStatus;


    public Payment(double amount) {
        this.transactionId = UUID.randomUUID().toString();
        this.creationDate = new Date();
        this.amount = amount;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public static PaymentInfo makePayment(ParkingTicket parkingTicket, PaymentType paymentType, double amount) {
        Payment payment;
        switch (paymentType) {
            case CARD:
                payment = new CreditCardPayment(amount);
                break;
            case CASH:
                payment = new CashPayment(amount);
                break;
            default:
                throw new UnsupportedOperationException("Invalid payment type");
        }
        return payment.initiateTransaction();
    }
    public abstract PaymentInfo initiateTransaction();
}
