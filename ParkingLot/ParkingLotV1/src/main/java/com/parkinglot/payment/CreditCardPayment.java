package com.parkinglot.payment;

import com.parkinglot.enums.PaymentStatus;
import com.parkinglot.enums.PaymentType;

public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate; // MM/YY format
    private String cvv;

    public CreditCardPayment(double amount, String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        super(amount);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public PaymentInfo initiateTransaction() {
        // Simulate card validation
        if (cardNumber != null && cardNumber.length() == 16) {
            setPaymentStatus(PaymentStatus.COMPLETED);
        } else {
            setPaymentStatus(PaymentStatus.FAILED);
        }

        return new PaymentInfo(
                transactionId,
                amount,
                paymentStatus,
                PaymentType.CARD

        );
    }

    // Getters
    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCvv() {
        return cvv;
    }
}
