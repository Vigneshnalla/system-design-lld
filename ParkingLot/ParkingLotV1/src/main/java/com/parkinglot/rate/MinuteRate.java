package com.parkinglot.rate;

public class MinuteRate extends ParkingRate{
    private final double perMinuteRate;

    public MinuteRate(double durationInMinutes, double perMinuteRate) {
        this.perMinuteRate = perMinuteRate;
    }

    @Override
    public double calculate() {
        return duration * perMinuteRate;
    }
}