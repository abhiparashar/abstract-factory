package com.remittance.strategy.impl.delivery;

import com.remittance.dto.DeliveryResult;
import com.remittance.model.RemittanceTransaction;
import com.remittance.strategy.interfaces.DeliveryStrategy;

import java.math.BigDecimal;

public class BankTransferStrategy implements DeliveryStrategy {
    @Override
    public DeliveryResult deliver(RemittanceTransaction transaction, String deliveryLocation) {
        return DeliveryResult.builder()
                .success(true)
                .message("Bank transfer initiated")
                .trackingNumber("BT" + System.currentTimeMillis())
                .estimatedDeliveryMinutes(240)
                .deliveryInstructions("Funds will be credited to recipient's bank account")
                .build();
    }

    @Override
    public int getEstimatedDeliveryTime() {
        return 240;
    }

    @Override
    public boolean isAvailableInCountry(String country) {
        return !country.equals("UNBANKED_REGION");
    }

    @Override
    public BigDecimal getDeliveryFee(String country, BigDecimal amount) {
        return BigDecimal.valueOf(2.50);
    }

    @Override
    public String getDeliveryMethod() {
        return "BANK_TRANSFER";
    }

    @Override
    public boolean requiresPhysicalPresence() {
        return false;
    }
}
