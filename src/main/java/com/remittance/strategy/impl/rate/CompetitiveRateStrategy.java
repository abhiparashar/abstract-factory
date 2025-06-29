package com.remittance.strategy.impl.rate;

import com.remittance.strategy.interfaces.ExchangeRateStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("competitiveRateStrategy")
public class CompetitiveRateStrategy implements ExchangeRateStrategy {

    @Override
    public BigDecimal getExchangeRate(String fromCurrency, String toCurrency) {
        BigDecimal rate = BigDecimal.valueOf(0.89); // Competitive rate
        System.out.println("Competitive Rate: " + fromCurrency + "/" + toCurrency + " = " + rate);
        return rate;
    }

    @Override
    public String getRateSource() {
        return "Competitive market rates";
    }

    @Override
    public String getStrategyType() {
        return "COMPETITIVE";
    }

    @Override
    public boolean isRealTime() {
        return true;
    }

    @Override
    public BigDecimal getMargin() {
        return BigDecimal.valueOf(1.5);
    }
}
