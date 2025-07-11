package com.parkinglot;

import com.parkinglot.display.ParkingDisplayBoard;
import com.parkinglot.enums.ParkingSpotType;
import com.parkinglot.enums.VehicleType;
import com.parkinglot.gate.Entrance;
import com.parkinglot.gate.Exit;
import com.parkinglot.parkingspot.ParkingSpot;
import com.parkinglot.rate.ParkingRate;
import com.parkinglot.tikcet.ParkingTicket;
import com.parkinglot.user.Location;
import com.parkinglot.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.*;

public class ParkingLot {

    private String name;
    private static ParkingLot instance;
    private Location location;
    private ParkingRate parkingRate;

    private Map<String, Entrance> entranceList = new HashMap<>();
    private Map<String, Exit> exitList = new HashMap<>();
    private Map<ParkingSpotType, List<ParkingSpot>> parkingSpots = new HashMap<>();

    private ParkingDisplayBoard displayBoard = new ParkingDisplayBoard("MAIN_BOARD");

    private ParkingLot() {}


    public static ParkingLot getInstance() {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) {
                    instance = new ParkingLot();
                }
            }
        }
        return instance;
    }

    // ------ Methods ---------
    public void addEntrance(Entrance entrance){
        entranceList.put(entrance.getEntranceId(),entrance);
    }
    public void addExit(Exit exit){
        exitList.put(exit.getExitId(), exit);
    }

    public void addParkingSpot(ParkingSpot parkingSpot, ParkingSpotType parkingSpotType){
        parkingSpots.computeIfAbsent(parkingSpotType, k -> new ArrayList<>()).add(parkingSpot);
        displayBoard.updateSpotAvailability(parkingSpotType.name(),parkingSpots.get(parkingSpotType));
    }

    public boolean isFull(ParkingSpotType parkingSpotType){
        List<ParkingSpot> spots = parkingSpots.get(parkingSpotType);
        
        if(spots == null) return true;
        return spots.stream().noneMatch(ParkingSpot::isSpotAvailable);
    }
    
    public ParkingSpot getAvailableSpot(Vehicle vehicle){
        ParkingSpotType parkingSpotType = getSpotTypeForVehicle(vehicle);
        List<ParkingSpot> spots = parkingSpots.get(parkingSpotType);
        if(spots == null) return null;
        return spots.stream().filter(ParkingSpot::isSpotAvailable).findFirst().orElse(null);
    }

    private ParkingSpotType getSpotTypeForVehicle(Vehicle vehicle) {
        switch (vehicle.getVehicleType()) {
            case CAR:
                return ParkingSpotType.COMPACT;
            case MOTORCYCLE:
                return ParkingSpotType.MOTORCYCLE;
            case TRUCK:
                return ParkingSpotType.LARGE;
            default:
                return ParkingSpotType.COMPACT;
        }
    }

    public ParkingDisplayBoard getDisplayBoard() {
        return displayBoard;
    }

    public Map<ParkingSpotType, List<ParkingSpot>> getParkingSpots() {
        return parkingSpots;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setParkingRate(ParkingRate parkingRate) {
        this.parkingRate = parkingRate;
    }

    public void setDisplayBoard(ParkingDisplayBoard displayBoard) {
        this.displayBoard = displayBoard;
    }

    public ParkingTicket getNewParkingTicket(Vehicle vehicle){
        ParkingSpot spot = getAvailableSpot(vehicle);
        if(spot == null) {
            System.out.println("No Available Spot for vehicle");
            return null;
        }

        boolean assigned = spot.assignVehicleToSpot(vehicle);
        if(!assigned) return null;

        displayBoard.updateSpotAvailability(spot.getParkingSpotType().name(), parkingSpots.get(spot.getParkingSpotType()));
        ParkingTicket parkingTicket = new ParkingTicket(
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                vehicle,
                spot
        );
        vehicle.assignParkingTicket(parkingTicket);
        return parkingTicket;
    }

    public void vacateSpot(ParkingSpot spot) {
        spot.vacateVehicleFromSpot(); // Mark it free
        displayBoard.updateSpotAvailability(spot.getParkingSpotType().name(), parkingSpots.get(spot.getParkingSpotType()));
    }

    public ParkingRate getParkingRate() {
        return parkingRate;
    }
}
