package com.remittance.strategy.impl.rate;

import com.remittance.strategy.interfaces.ExchangeRateStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("bankRateStrategy")
public class BankRateStrategy implements ExchangeRateStrategy {

    @Override
    public BigDecimal getExchangeRate(String fromCurrency, String toCurrency) {
        BigDecimal rate = BigDecimal.valueOf(0.85);
        System.out.println("Bank Rate: " + fromCurrency + "/" + toCurrency + " = " + rate);
        return rate;
    }

    @Override
    public String getRateSource() {
        return "Central Bank Rates + 3% margin";
    }

    @Override
    public String getStrategyType() {
        return "BANK";
    }

    @Override
    public boolean isRealTime() {
        return false;
    }

    @Override
    public BigDecimal getMargin() {
        return BigDecimal.valueOf(3.0);
    }
}
