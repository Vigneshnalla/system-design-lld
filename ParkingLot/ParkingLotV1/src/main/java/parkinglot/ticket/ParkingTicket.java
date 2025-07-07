package parkinglot.ticket;

import parkinglot.enums.ParkingTicketStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingTicket {
    private final String parkingTicketId;
    private final int vehicleId;
    private final int parkingSpotId;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private ParkingTicketStatus status;
    private boolean isPaid;
    private double amount;

    public ParkingTicket(LocalDateTime entryTime, int vehicleId, int parkingSpotId) {
        this.parkingTicketId = UUID.randomUUID().toString();
        this.entryTime = entryTime;
        this.vehicleId = vehicleId;
        this.parkingSpotId = parkingSpotId;
        this.isPaid = false;
        this.status = ParkingTicketStatus.ACTIVE;
    }

    public String getParkingTicketId() {
        return parkingTicketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public int getParkingSpotId() {
        return parkingSpotId;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public double getAmount() {
        return amount;
    }

    public ParkingTicketStatus getStatus() {
        return status;
    }


    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public void markAsPaid() {
        this.isPaid = true;
    }

    public void closeTicket() {
        this.exitTime = LocalDateTime.now();
        this.status = ParkingTicketStatus.CLOSED;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setStatus(ParkingTicketStatus status) {
        this.status = status;
    }
}
