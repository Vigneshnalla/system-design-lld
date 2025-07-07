package parkinglot.pricing;

import java.time.LocalDateTime;

public class PerMinutePricingPolicy implements PricingPolicy {
    private final double perMinuteRate;

    public PerMinutePricingPolicy(double perMinuteRate) {
        this.perMinuteRate = perMinuteRate;
    }

    @Override
    public double calculatePrice(LocalDateTime entry, LocalDateTime exit) {
        long minutes = java.time.Duration.between(entry, exit).toMinutes();
        return minutes * perMinuteRate;
    }
}
