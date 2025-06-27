package com.remittance.strategy;

public interface DeliveryStrategy {
    void deliver();
    void getEstimatedDeliveryTime();
    void isAvailableInCountry();
}
