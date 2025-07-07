package parkinglot.payment;

import parkinglot.enums.PaymentStatus;

import java.util.Date;

public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(double amount, String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        super(amount);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean initiateTransaction() {
        // Simulate card processing
        // In real life, call payment gateway API here

        if (isValidCardDetails()) {
            setStatus(PaymentStatus.COMPLETED);
            setTimestamp(new Date());
            return true;
        } else {
            setStatus(PaymentStatus.FAILED);
            return false;
        }
    }

    private boolean isValidCardDetails() {
        // Dummy validation — you can enhance this
        return cardNumber != null && cardNumber.length() == 16 && cvv.length() == 3;
    }
}
