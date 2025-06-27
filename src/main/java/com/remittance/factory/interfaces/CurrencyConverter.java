package com.remittance.factory.interfaces;

import java.math.BigDecimal;

public interface CurrencyConverter {
    BigDecimal convertCurrency(BigDecimal amount, String fromCurrency, String toCurrency);
    BigDecimal getExchangeRate(String fromCurrency, String toCurrency);
    String getRateSource();
    boolean isCurrencySupported(String currency);
}
