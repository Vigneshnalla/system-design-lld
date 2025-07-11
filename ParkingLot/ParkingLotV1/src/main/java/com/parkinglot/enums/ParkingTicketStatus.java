package com.parkinglot.enums;

public enum ParkingTicketStatus {
    ACTIVE, // Ticket is in use
    CLOSED, // Ticket is finalized and vehicle has existed
    PAID,  // Payment has been completed, but vehicle hasn't existed
    EXPIRED, // Ticket has overstayed allowed duration
    LOST // Ticket is lost
}
