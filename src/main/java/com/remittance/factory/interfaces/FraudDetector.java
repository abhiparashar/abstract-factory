package com.remittance.factory.interfaces;

import com.remittance.factory.FraudCheckResult;
import com.remittance.model.RemittanceTransaction;

import java.math.BigDecimal;

public interface FraudDetector {
    FraudCheckResult detectFraud(RemittanceTransaction transaction);
    void logFraudAttempt(String transactionId, String reason);
    double calculateRiskScore(String customerId, BigDecimal amount, String country);
}
