package com.remittance.strategy.impl.delivery;

import com.remittance.dto.DeliveryResult;
import com.remittance.model.RemittanceTransaction;
import com.remittance.strategy.interfaces.DeliveryStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component("cashPickupStrategy")
public class CashPickupStrategy implements DeliveryStrategy {
    @Override
    public DeliveryResult deliver(RemittanceTransaction transaction, String deliveryLocation) {
        return DeliveryResult.builder()
                .success(true)
                .message("Cash pickup arranged")
                .deliveryCode("PICKUP" + UUID.randomUUID().toString().substring(0, 6).toUpperCase())
                .estimatedDeliveryMinutes(15)
                .deliveryInstructions("Present valid ID and pickup code at any agent location")
                .build();
    }

    @Override
    public int getEstimatedDeliveryTime() {
        return 15;
    }

    @Override
    public boolean isAvailableInCountry(String country) {
        return !country.equals("REMOTE_COUNTRY");
    }

    @Override
    public BigDecimal getDeliveryFee(String country, BigDecimal amount) {
        return BigDecimal.ZERO;
    }

    @Override
    public String getDeliveryMethod() {
        return "CASH_PICKUP";
    }

    @Override
    public boolean requiresPhysicalPresence() {
        return true;
    }
}
