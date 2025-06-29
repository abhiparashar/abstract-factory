package com.remittance.strategy.impl.delivery;

import com.remittance.dto.DeliveryResult;
import com.remittance.model.RemittanceTransaction;
import com.remittance.strategy.interfaces.DeliveryStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("homeDeliveryStrategy")
public class HomeDeliveryStrategy implements DeliveryStrategy {
    @Override
    public DeliveryResult deliver(RemittanceTransaction transaction, String deliveryLocation) {
        return DeliveryResult.builder()
                .success(true)
                .message("Home delivery scheduled")
                .estimatedDeliveryMinutes(1440)
                .trackingNumber("HD" + System.currentTimeMillis())
                .deliveryInstructions("Agent will deliver cash to specified address")
                .build();
    }

    @Override
    public int getEstimatedDeliveryTime() {
        return 1440;
    }

    @Override
    public boolean isAvailableInCountry(String country) {
        return country.equals("INDIA") || country.equals("PAKISTAN") ||
                country.equals("BANGLADESH") || country.equals("NEPAL");
    }

    @Override
    public BigDecimal getDeliveryFee(String country, BigDecimal amount) {
        return BigDecimal.valueOf(5.00);
    }

    @Override
    public String getDeliveryMethod() {
        return "HOME_DELIVERY";
    }

    @Override
    public boolean requiresPhysicalPresence() {
        return true;
    }
}
