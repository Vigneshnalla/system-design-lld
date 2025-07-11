package com.parkinglot.rate;


public abstract class ParkingRate {
    protected double duration; // in hours or minutes, depending on strategy

    protected ParkingRate() {
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public abstract double calculate();
}

