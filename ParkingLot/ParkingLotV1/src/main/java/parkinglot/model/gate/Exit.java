package parkinglot.model.gate;

import parkinglot.enums.ParkingTicketStatus;
import parkinglot.enums.TicketValidationStatus;
import parkinglot.parking.ParkingSpot;
import parkinglot.system.ParkingLot;
import parkinglot.ticket.ParkingTicket;

import java.time.Duration;
import java.time.LocalDateTime;

public class Exit {
    private final String id;
    private final ParkingLot parkingLotSystem;

    public Exit(String id, ParkingLot parkingLotSystem) {
        this.id = id;
        this.parkingLotSystem = parkingLotSystem;
    }

    public String getId() {
        return id;
    }
    public TicketValidationStatus validateTicket(ParkingTicket parkingTicket) {
        String parkingTicketId = parkingTicket.getParkingTicketId();
        ParkingTicket ticket = parkingLotSystem.getActiveTicket(parkingTicketId); // Add this helper

        if (ticket == null) return TicketValidationStatus.INVALID;

        if (ticket.getStatus() == ParkingTicketStatus.CANCELLED) return TicketValidationStatus.CANCELLED;

        if (ticket.getStatus() == ParkingTicketStatus.CLOSED) return TicketValidationStatus.ALREADY_EXITED;

        if (!ticket.isPaid()) return TicketValidationStatus.NOT_PAID;

        return TicketValidationStatus.VALID;
    }


    public ParkingTicket checkOut(ParkingTicket parkingTicket){
        LocalDateTime now = LocalDateTime.now();
        parkingTicket.setExitTime(now);

        double price = parkingLotSystem.getPricingPolicy().calculatePrice(parkingTicket.getEntryTime(), now);
        parkingTicket.setAmount(price);
        parkingTicket.markAsPaid();
        parkingTicket.setStatus(ParkingTicketStatus.CLOSED);
        int spotId = parkingTicket.getParkingSpotId();
        ParkingSpot spot = parkingLotSystem.getParkingSpotById(spotId); // You need to implement this
        if (spot != null) spot.vacateVehicleFromSpot();
        return parkingTicket;
    }
    public double calculatePrice(ParkingTicket parkingTicket){
        LocalDateTime entry = parkingTicket.getEntryTime();
        LocalDateTime exit = LocalDateTime.now();
        return parkingLotSystem.getPricingPolicy().calculatePrice(entry, exit);
    }
    public int calculateDurationInHours(ParkingTicket parkingTicket) {
        LocalDateTime entryTime = parkingTicket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();

        long minutes = Duration.between(entryTime, exitTime).toMinutes();
        return (int) Math.ceil(minutes / 60.0);
    }

}
