package com.parkinglot.rate;

public class HourlyRate extends ParkingRate{
    double hourlyRate;

    public HourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculate() {
        return hourlyRate * duration;
    }
}
