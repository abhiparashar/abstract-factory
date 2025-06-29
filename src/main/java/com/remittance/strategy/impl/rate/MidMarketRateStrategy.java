package com.remittance.strategy.impl.rate;

import com.remittance.strategy.interfaces.ExchangeRateStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("midMarketRateStrategy")
public class MidMarketRateStrategy implements ExchangeRateStrategy {
    @Override
    public BigDecimal getExchangeRate(String fromCurrency, String toCurrency) {
        BigDecimal rate = BigDecimal.valueOf(0.92);
        System.out.println("Mid-Market Rate: " + fromCurrency + "/" + toCurrency + " = " + rate);
        return rate;
    }

    @Override
    public String getRateSource() {
        return "Live mid-market rates";
    }

    @Override
    public String getStrategyType() {
        return "MID_MARKET";
    }

    @Override
    public boolean isRealTime() {
        return true;
    }

    @Override
    public BigDecimal getMargin() {
        return BigDecimal.ZERO;
    }
}
