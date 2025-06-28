package com.remittance.strategy.impl.fee;

import com.remittance.strategy.interfaces.FeeCalculationStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("fixedFeeStrategy")
public class FixedFeeStrategy implements FeeCalculationStrategy {

    private final BigDecimal fixedFee;

    public FixedFeeStrategy(){
        this.fixedFee = BigDecimal.valueOf(9.99);
    }

    public FixedFeeStrategy(BigDecimal fixedFee){
        this.fixedFee = fixedFee;
    }

    @Override
    public BigDecimal calculateFee(BigDecimal amount, String fromCountry, String toCountry) {
        return fixedFee;
    }

    @Override
    public String getDescription() {
        return "Fixed Fee of $" + fixedFee;
    }

    @Override
    public String getStrategyType() {
        return "FIXED";
    }

    @Override
    public BigDecimal getMinimumFee() {
        return fixedFee;
    }

    @Override
    public BigDecimal getMaximumFee() {
        return fixedFee;
    }
}
