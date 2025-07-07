package parkinglot.pricing;

import java.time.LocalDateTime;

public class TieredPricingPolicy implements PricingPolicy {
    @Override
    public double calculatePrice(LocalDateTime entry, LocalDateTime exit) {
        long totalMinutes = java.time.Duration.between(entry, exit).toMinutes();
        long totalHours = (totalMinutes + 59) / 60;

        if (totalHours <= 2) {
            return 100;
        } else {
            return 100 + (totalHours - 2) * 60;
        }
    }
}
