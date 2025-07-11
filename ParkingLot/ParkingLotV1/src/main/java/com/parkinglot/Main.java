package com.parkinglot;

import com.parkinglot.display.ParkingDisplayBoard;
import com.parkinglot.enums.ParkingSpotType;
import com.parkinglot.enums.VehicleType;
import com.parkinglot.gate.Entrance;
import com.parkinglot.gate.Exit;
import com.parkinglot.parkingspot.CompactSpot;
import com.parkinglot.parkingspot.HandicappedSpot;
import com.parkinglot.parkingspot.MotorCycleSpot;
import com.parkinglot.parkingspot.ParkingSpot;
import com.parkinglot.rate.HourlyRate;
import com.parkinglot.tikcet.ParkingTicket;
import com.parkinglot.user.Location;
import com.parkinglot.vehicle.Car;
import com.parkinglot.vehicle.MotorCycle;
import com.parkinglot.vehicle.Van;
import com.parkinglot.vehicle.Vehicle;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");

        ParkingLot lot = ParkingLot.getInstance();
        lot.setLocation(new Location("1st Main", "Bangalore", "Karnataka", "560001", "India"));
        lot.setParkingRate(new HourlyRate(50)); // ₹50 per hour

        Entrance entrance = new Entrance("E1");
        Exit exit = new Exit("X1"); // No ParkingRate needed
        lot.addEntrance(entrance);
        lot.addExit(exit);

        for (int i = 1; i <= 3; i++) {
            ParkingSpot spot = new CompactSpot("C" + i);
            lot.addParkingSpot(spot, ParkingSpotType.COMPACT);
        }
        for (int i = 1; i <= 3; i++) {
            ParkingSpot spot = new HandicappedSpot("H" + i);
            lot.addParkingSpot(spot, ParkingSpotType.HANDICAPPED);
        }
        for (int i = 1; i <= 2; i++) {
            ParkingSpot spot = new MotorCycleSpot("M" + i);
            lot.addParkingSpot(spot, ParkingSpotType.MOTORCYCLE);
        }

        System.out.println("\n=== Before Parking ===");

        Vehicle car1= new Car("KA01AB1234");
        Vehicle car2= new Car("KA01AB1235");
        Vehicle v1= new MotorCycle("KA01AB1235");
        Vehicle v2= new MotorCycle("KA01AB1236");
        Vehicle v3= new MotorCycle("KA01AB1237");

        Vehicle h1 = new Van("V12432424");


        ParkingTicket parkingTicket1 = entrance.getNewParkingTicket(car1);
        System.out.println(parkingTicket1);
        if (parkingTicket1 != null) {
            System.out.println("\n✅ Ticket Issued: " + parkingTicket1.getParkingTicketId());
            System.out.println("Assigned Spot: " + parkingTicket1.getParkingSpot().getParkingSpotId());
        } else {
            System.out.println("❌ No spot available.");
            return;
        }

        ParkingTicket parkingTicket2 = entrance.getNewParkingTicket(v1);
//        System.out.println(parkingTicket2);


        ParkingTicket parkingTicket3 = entrance.getNewParkingTicket(v2);
//        System.out.println(parkingTicket2);
        ParkingTicket parkingTicket4 = entrance.getNewParkingTicket(v3);
//        System.out.println(parkingTicket2);

        System.out.println("\n=== After Parking ===");
        lot.getDisplayBoard().showAvailability();

        Thread.sleep(60_000); // wait 60,000 milliseconds = 1 minute


        double price = exit.checkout(parkingTicket1);
        System.out.println("\n✅ Checked Out. Amount Paid: ₹" + price);

    }
}