package com.parkinglot.tikcet;

import com.parkinglot.enums.ParkingTicketStatus;
import com.parkinglot.parkingspot.ParkingSpot;
import com.parkinglot.payment.PaymentInfo;
import com.parkinglot.vehicle.Vehicle;

import java.time.LocalDateTime;

public class ParkingTicket {

    private final String parkingTicketId;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;

    private double amount;
    private ParkingTicketStatus parkingTicketStatus;
    private boolean isPaid;
    private PaymentInfo paymentInfo; // ✅ for tracking how payment was made

    // Constructor
    public ParkingTicket(String parkingTicketId, LocalDateTime entryTime, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.parkingTicketId = parkingTicketId;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.parkingTicketStatus = ParkingTicketStatus.ACTIVE;
        this.isPaid = false;
    }

    // Getters
    public String getParkingTicketId() {
        return parkingTicketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public double getAmount() {
        return amount;
    }

    public ParkingTicketStatus getStatus() {
        return parkingTicketStatus;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    // Setters
    public void setStatus(ParkingTicketStatus status) {
        this.parkingTicketStatus = status;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public void markAsPaid(boolean paid) {
        this.isPaid = paid;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public void closeTicket() {
        this.exitTime = LocalDateTime.now();
        this.parkingTicketStatus = ParkingTicketStatus.CLOSED;
    }

    // Override toString for logging/debugging
    @Override
    public String toString() {
        return "ParkingTicket{" +
                "ticketId='" + parkingTicketId + '\'' +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", vehicle=" + vehicle +
                ", spot=" + parkingSpot +
                ", amount=" + amount +
                ", status=" + parkingTicketStatus +
                ", isPaid=" + isPaid +
                ", paymentInfo=" + paymentInfo +
                '}';
    }
}
