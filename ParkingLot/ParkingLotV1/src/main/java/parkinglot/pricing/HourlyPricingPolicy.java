package parkinglot.pricing;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPricingPolicy implements PricingPolicy {
    private final double hourlyRate;

    public HourlyPricingPolicy(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatePrice(LocalDateTime entryTime, LocalDateTime exitTime) {
        if (exitTime.isBefore(entryTime)) {
            throw new IllegalArgumentException("Exit time cannot be before entry time.");
        }

        long minutes = Duration.between(entryTime, exitTime).toMinutes();
        long hours = (minutes + 59) / 60;  // Round up to the next hour
        return hours * hourlyRate;
    }
}
