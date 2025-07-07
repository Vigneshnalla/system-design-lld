package parkinglot.pricing;


import java.time.LocalDateTime;

public interface PricingPolicy {
    double calculatePrice(LocalDateTime entryTime, LocalDateTime exitTime);
}
