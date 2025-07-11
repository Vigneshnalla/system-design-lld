package com.parkinglot.payment;


import com.parkinglot.enums.PaymentStatus;
import com.parkinglot.enums.PaymentType;

public class PaymentInfo {
    private String transactionId;
    private double amount;
    private PaymentStatus status;
    private PaymentType method;
    public PaymentInfo(String transactionId, double amount, PaymentStatus status, PaymentType method) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.status = status;
        this.method = method;
    }

    // Getters and toString()...
}
