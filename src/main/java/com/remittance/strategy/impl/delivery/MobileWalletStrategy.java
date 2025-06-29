package com.remittance.strategy.impl.delivery;

import com.remittance.dto.DeliveryResult;
import com.remittance.model.RemittanceTransaction;
import com.remittance.strategy.interfaces.DeliveryStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("mobileWalletStrategy")
public class MobileWalletStrategy implements DeliveryStrategy {
    @Override
    public DeliveryResult deliver(RemittanceTransaction transaction, String deliveryLocation) {
        return DeliveryResult.builder()
                .success(true)
                .message("Mobile wallet transfer completed")
                .deliveryCode("MW" + System.currentTimeMillis())
                .estimatedDeliveryMinutes(2)
                .deliveryInstructions("Mobile Wallet: Instant transfer completed")
                .build();
    }

    @Override
    public int getEstimatedDeliveryTime() {
        return 2;
    }

    @Override
    public boolean isAvailableInCountry(String country) {
        return country.equals("KENYA") || country.equals("GHANA") ||
                country.equals("PHILIPPINES") || country.equals("UGANDA");
    }

    @Override
    public BigDecimal getDeliveryFee(String country, BigDecimal amount) {
        return BigDecimal.valueOf(1);
    }

    @Override
    public String getDeliveryMethod() {
        return "MOBILE_WALLET";
    }

    @Override
    public boolean requiresPhysicalPresence() {
        return false;
    }
}
