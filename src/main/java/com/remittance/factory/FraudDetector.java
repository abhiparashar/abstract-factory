package com.remittance.factory;

public interface FraudDetector {
    void detectFraud();
    void calculateRiskScore();
    void logFraudAttempt();
}
