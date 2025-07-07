package parkinglot.system;

import parkinglot.enums.ParkingSpotType;
import parkinglot.enums.ParkingTicketStatus;
import parkinglot.model.Address;
import parkinglot.model.gate.Entrance;
import parkinglot.model.gate.Exit;
import parkinglot.parking.ParkingSpot;
import parkinglot.pricing.PricingPolicy;
import parkinglot.ticket.ParkingTicket;
import parkinglot.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.*;

public class ParkingLot {
    private static ParkingLot instance;

    private final PricingPolicy pricingPolicy;
    private final Map<ParkingSpotType, List<ParkingSpot>> parkingSpots;
    private final Map<String, Entrance> entranceList;
    private final Map<String, Exit> exitList;
    private final Map<String, ParkingTicket> activeTickets;
    private final Map<Integer, ParkingTicket> vehicleIdToTicketMap;
    private final Map<Integer, ParkingSpot> spotIdMap;

    private ParkingLot(String name, Address address, PricingPolicy pricingPolicy) {
        this.pricingPolicy = pricingPolicy;
        this.parkingSpots = new HashMap<>();
        this.entranceList = new HashMap<>();
        this.exitList = new HashMap<>();
        this.activeTickets = new HashMap<>();
        this.vehicleIdToTicketMap = new HashMap<>();
        this.spotIdMap = new HashMap<>();
    }

    // Thread-safe Singleton instantiation
    public static synchronized ParkingLot getInstance(String name, Address address, PricingPolicy pricingPolicy) {
        if (instance == null) {
            instance = new ParkingLot(name, address, pricingPolicy);
        }
        return instance;
    }

    public void addEntrance(Entrance entrance) {
        entranceList.put(entrance.getId(), entrance);
    }

    public void addExit(Exit exit) {
        exitList.put(exit.getId(), exit);
    }

    public void addParkingSpot(ParkingSpotType type, ParkingSpot spot) {
        parkingSpots.putIfAbsent(type, new ArrayList<>());
        parkingSpots.get(type).add(spot);
        spotIdMap.put(spot.getParkingSpotId(), spot);
    }

    public ParkingSpot getParkingSpotById(int spotId) {
        return spotIdMap.get(spotId);
    }

    public ParkingTicket getParkingTicket(Vehicle vehicle) {
        ParkingSpotType type = vehicle.getType();
        List<ParkingSpot> spots = parkingSpots.getOrDefault(type, new ArrayList<>());

        for (ParkingSpot spot : spots) {
            if (spot.isSpotFree() && spot.assignVehicleToSpot(vehicle)) {
                ParkingTicket ticket = new ParkingTicket(LocalDateTime.now(), vehicle.getLicenceNo(), spot.getParkingSpotId());
                activeTickets.put(ticket.getParkingTicketId(), ticket);
                vehicleIdToTicketMap.put(vehicle.getLicenceNo(), ticket);
                return ticket;
            }
        }

        throw new RuntimeException("No available spots for type: " + type);
    }

    public ParkingTicket getActiveTicket(String parkingTicketId) {
        return activeTickets.get(parkingTicketId);
    }

    public void removeTicket(String parkingTicketId, int vehicleId) {
        activeTickets.remove(parkingTicketId);
        vehicleIdToTicketMap.remove(vehicleId);
    }

    public boolean isFull(ParkingSpotType type) {
        List<ParkingSpot> spots = parkingSpots.getOrDefault(type, new ArrayList<>());
        for (ParkingSpot spot : spots) {
            if (spot.isSpotFree()) return false;
        }
        return true;
    }

    public ParkingSpotType getSpotTypeForVehicle(Vehicle vehicle) {
        return vehicle.getType(); // Can be extended with more logic if needed
    }

    public ParkingSpot getAvailableSpot(Vehicle vehicle) {
        ParkingSpotType type = getSpotTypeForVehicle(vehicle);
        List<ParkingSpot> spots = parkingSpots.getOrDefault(type, new ArrayList<>());

        for (ParkingSpot spot : spots) {
            if (spot.isSpotFree()) return spot;
        }

        return null;
    }

    public PricingPolicy getPricingPolicy() {
        return this.pricingPolicy;
    }
}
