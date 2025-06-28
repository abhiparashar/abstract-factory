package com.remittance.strategy.interfaces;

import java.math.BigDecimal;

public interface FeeCalculationStrategy {
    BigDecimal calculateFee(BigDecimal amount, String fromCountry, String toCountry);
    String getDescription();
    String getStrategyType();
    BigDecimal getMinimumFee();
    BigDecimal getMaximumFee();
}
