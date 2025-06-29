package com.remittance.strategy.interfaces;

import java.math.BigDecimal;

public interface ExchangeRateStrategy {
    BigDecimal getExchangeRate(String fromCurrency, String toCurrency);
    String getRateSource();
    String getStrategyType();
    boolean isRealTime();
    BigDecimal getMargin();
}
