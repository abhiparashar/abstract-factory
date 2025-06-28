package com.remittance.strategy.impl.fee;

import com.remittance.strategy.interfaces.FeeCalculationStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component("percentageFeeStrategy")
public class PercentageFeeStrategy implements FeeCalculationStrategy {
    private final BigDecimal percentage;
    private final BigDecimal minFee;
    private final BigDecimal maxFee;

    public PercentageFeeStrategy() {
        this.percentage = BigDecimal.valueOf(2.0);
        this.minFee = BigDecimal.valueOf(4.99);
        this.maxFee = BigDecimal.valueOf(50.0);
    }

    public PercentageFeeStrategy(BigDecimal percentage, BigDecimal minFee, BigDecimal maxFee ){
        this.percentage = percentage;
        this.minFee = minFee;
        this.maxFee = maxFee;
    }

    @Override
    public BigDecimal calculateFee(BigDecimal amount, String fromCountry, String toCountry) {
        BigDecimal fee = amount.multiply(percentage.divide(BigDecimal.valueOf(100)));
        if(fee.compareTo(minFee)<0)  fee = minFee;
        if(fee.compareTo(maxFee)>0) fee = maxFee;
        fee = fee.setScale(2, RoundingMode.HALF_UP);
        return fee;
    }

    @Override
    public String getDescription() {
        return percentage + "% (min: $" + minFee + ", max: $" + maxFee + ")";
    }

    @Override
    public String getStrategyType() {
        return "PERCENTAGE";
    }

    @Override
    public BigDecimal getMinimumFee() {
        return minFee;
    }

    @Override
    public BigDecimal getMaximumFee() {
        return maxFee;
    }
}
