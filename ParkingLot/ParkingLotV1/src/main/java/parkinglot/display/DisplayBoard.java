package parkinglot.display;

import parkinglot.parking.ParkingSpot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayBoard {

    private String id;
    private final Map<String, Integer> availableSpotCountByType;

    DisplayBoard(String id){
        this.id = id;
        this.availableSpotCountByType = new HashMap<>();
    }

    public void updateSpotAvailability(String type, List<ParkingSpot> spotList) {
        int count = 0;
        for (ParkingSpot spot : spotList) {
            if (spot.isSpotFree()) {
                count++;
            }
        }
        availableSpotCountByType.put(type, count);
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
