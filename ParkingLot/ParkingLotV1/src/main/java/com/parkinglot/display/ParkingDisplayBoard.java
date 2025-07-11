package com.parkinglot.display;

import com.parkinglot.parkingspot.ParkingSpot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingDisplayBoard {
    private String id;
    private Map<String, Integer> availableSpotCountByType = new HashMap<>();

    public ParkingDisplayBoard(String id){
        this.id = id;
    }

    public void updateSpotAvailability(String type, List<ParkingSpot> spotList) {
        int count = 0;
        for (ParkingSpot spot : spotList) {
            if (spot.isSpotAvailable()) {
                count++;
            }
        }
        availableSpotCountByType.put(type, count);
    }

    public void updateAvailability(List<ParkingSpot> spotList) {
        availableSpotCountByType.clear();

        for (ParkingSpot parkingSpot : spotList) {
            if (parkingSpot.isSpotAvailable()) {
                String type = parkingSpot.getParkingSpotType().name();
                availableSpotCountByType.put(type, availableSpotCountByType.getOrDefault(type, 0) + 1);
            }
        }
    }

    public void showAvailability() {
        System.out.println("---- Parking Spot Availability ----");
        for (Map.Entry<String, Integer> entry : availableSpotCountByType.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " spots available");
        }
    }

    public int getAvailableCount(String type) {
        return availableSpotCountByType.getOrDefault(type, 0);
    }
}
