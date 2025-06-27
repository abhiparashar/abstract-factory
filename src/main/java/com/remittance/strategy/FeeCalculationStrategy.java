package com.remittance.strategy;

public interface FeeCalculationStrategy {
    void calculateFee();
    void getDescription();
    void getMinimumFee();
}
