package com.remittance.strategy.interfaces;

public interface DeliveryStrategy {
    void deliver();
    void getEstimatedDeliveryTime();
    void isAvailableInCountry();
}
