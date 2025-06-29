package com.remittance.strategy.interfaces;

import com.remittance.dto.DeliveryResult;
import com.remittance.model.RemittanceTransaction;

import java.math.BigDecimal;

public interface DeliveryStrategy {
    DeliveryResult deliver(RemittanceTransaction transaction, String deliveryLocation);
    int getEstimatedDeliveryTime(); // in minutes
    boolean isAvailableInCountry(String country);
    BigDecimal getDeliveryFee(String country, BigDecimal amount);
    String getDeliveryMethod();
    boolean requiresPhysicalPresence();
}
