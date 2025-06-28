package com.remittance.strategy.impl.fee;

import com.remittance.strategy.interfaces.FeeCalculationStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component("promotionalFeeStrategy")
public class PromotionalFeeStrategy implements FeeCalculationStrategy {

    private final FeeCalculationStrategy baseStrategy;
    private final BigDecimal discountPercentage;

    public PromotionalFeeStrategy(){
        this.baseStrategy = new TieredFeeStrategy();
        this.discountPercentage = BigDecimal.valueOf(50);
    }

    public PromotionalFeeStrategy(FeeCalculationStrategy baseStrategy, BigDecimal discountPercentage){
        this.baseStrategy = baseStrategy;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public BigDecimal calculateFee(BigDecimal amount, String fromCountry, String toCountry) {
        BigDecimal baseFee = baseStrategy.calculateFee(amount, fromCountry, toCountry);
        BigDecimal discount = baseFee.multiply(discountPercentage.divide(BigDecimal.valueOf(100)));
        BigDecimal finalFee = baseFee.subtract(discount).setScale(2, RoundingMode.HALF_UP);

        System.out.println("Promotional Fee: " + discountPercentage + "% off -> $" + finalFee);
        return finalFee;
    }

    @Override
    public String getDescription() {
        return "Promotional: " + discountPercentage + "% off " + baseStrategy.getDescription();
    }

    @Override
    public String getStrategyType() {
        return "PROMOTIONAL";
    }

    @Override
    public BigDecimal getMinimumFee() {
        return baseStrategy.getMinimumFee().multiply(
                BigDecimal.ONE.subtract(discountPercentage.divide(BigDecimal.valueOf(100)))
        );
    }

    @Override
    public BigDecimal getMaximumFee() {
        return baseStrategy.getMaximumFee().multiply(
                BigDecimal.ONE.subtract(discountPercentage.divide(BigDecimal.valueOf(100)))
        );
    }
}
