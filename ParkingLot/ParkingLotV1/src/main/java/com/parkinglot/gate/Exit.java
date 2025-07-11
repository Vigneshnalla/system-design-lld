package com.parkinglot.gate;

import com.parkinglot.ParkingLot;
import com.parkinglot.enums.ParkingTicketStatus;
import com.parkinglot.enums.PaymentType;
import com.parkinglot.parkingspot.ParkingSpot;
import com.parkinglot.payment.Payment;
import com.parkinglot.payment.PaymentInfo;
import com.parkinglot.rate.ParkingRate;
import com.parkinglot.tikcet.ParkingTicket;

import java.time.Duration;
import java.time.LocalDateTime;

public class Exit {

    private String exitId;
    private final ParkingLot parkingLot;

    public Exit(String exitId) {
        this.exitId = exitId;
        this.parkingLot = ParkingLot.getInstance();
    }

    public String getExitId() {
        return this.exitId;
    }

    public boolean validateTicket(ParkingTicket parkingTicket) {
        return parkingTicket != null &&
                parkingTicket.getStatus() == ParkingTicketStatus.ACTIVE &&
                parkingTicket.getExitTime() == null;
    }

    public double calculateDuration(ParkingTicket parkingTicket) {
        LocalDateTime entry = parkingTicket.getEntryTime();
        LocalDateTime exit = LocalDateTime.now();
        Duration duration = Duration.between(entry, exit);
        double hours = duration.toMinutes() / 60.0;
        return Math.max(1, Math.ceil(hours)); // round up and ensure minimum 1 hour
    }

    public double calculatePrice(ParkingTicket parkingTicket) {
        double hours = calculateDuration(parkingTicket);
        ParkingRate rate = parkingLot.getParkingRate();
        rate.setDuration(hours);
        return rate.calculate();
    }

    public double checkout(ParkingTicket parkingTicket, PaymentType paymentType) {
        if (!validateTicket(parkingTicket)) {
            throw new IllegalStateException("Invalid or already used ticket");
        }

        double price = calculatePrice(parkingTicket);

        // Delegate payment processing
        PaymentInfo paymentInfo = Payment.makePayment(parkingTicket, paymentType, price);

        // Update ticket details
        parkingTicket.setExitTime(LocalDateTime.now());
        parkingTicket.setAmount(price);
        parkingTicket.setStatus(ParkingTicketStatus.CLOSED);
        parkingTicket.markAsPaid(true);
        parkingTicket.setPaymentInfo(paymentInfo); // optional but recommended

        // Vacate the spot
        parkingLot.vacateSpot(parkingTicket.getParkingSpot());

        System.out.println("✅ Payment completed: " + paymentInfo);

        return price;
    }
}
