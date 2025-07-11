package com.parkinglot.rate;

import java.util.List;

public class TieredHourlyRate extends ParkingRate {
    private final List<Double> hourlyRates; // e.g., [30.0, 40.0, 50.0]

    public TieredHourlyRate( List<Double> hourlyRates) {
        this.hourlyRates = hourlyRates;
    }

    @Override
    public double calculate() {
        int fullHours = (int) Math.ceil(duration);
        double total = 0.0;
        for (int i = 0; i < fullHours; i++) {
            if (i < hourlyRates.size()) {
                total += hourlyRates.get(i);
            } else {
                total += hourlyRates.get(hourlyRates.size() - 1); // Use last rate as default
            }
        }
        return total;
    }
}
