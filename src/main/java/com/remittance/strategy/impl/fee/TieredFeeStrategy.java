package com.remittance.strategy.impl.fee;

import com.remittance.strategy.interfaces.FeeCalculationStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component("tieredFeeStrategy")
public class TieredFeeStrategy implements FeeCalculationStrategy {
    @Override
    public BigDecimal calculateFee(BigDecimal amount, String fromCountry, String toCountry) {
        BigDecimal fee;
        if (amount.compareTo(BigDecimal.valueOf(500)) <= 0) {
            fee = BigDecimal.valueOf(5.99);
        } else if (amount.compareTo(BigDecimal.valueOf(1000)) <= 0) {
            fee = BigDecimal.valueOf(7.99);
        } else if (amount.compareTo(BigDecimal.valueOf(5000)) <= 0) {
            fee = BigDecimal.valueOf(12.99);
        } else {
            fee = amount.multiply(BigDecimal.valueOf(0.005)); // 0.5%
        }

        // Country-specific adjustments
        if("DEVELOPING_COUNTRY".equals(toCountry)){
            fee = fee.multiply(BigDecimal.valueOf(1.2));
        }
        fee = fee.setScale(2, RoundingMode.HALF_UP);
        return fee;
    }

    @Override
    public String getDescription() {
        return "Tiered: $5.99 (≤$500), $7.99 (≤$1000), $12.99 (≤$5000), 0.5% (>$5000)";
    }

    @Override
    public String getStrategyType() {
        return "TIERED";
    }

    @Override
    public BigDecimal getMinimumFee() {
        return BigDecimal.valueOf(5.99);
    }

    @Override
    public BigDecimal getMaximumFee() {
        return BigDecimal.valueOf(250.0);
    }
}
