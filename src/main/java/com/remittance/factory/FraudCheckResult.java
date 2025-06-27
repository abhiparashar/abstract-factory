package com.remittance.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckResult {
    private boolean fraudDetected;
    private double riskScore;
    private String reason;
    private String riskLevel; // LOW, MEDIUM, HIGH
    private boolean requiresManualReview;

    public FraudCheckResult(boolean fraudDetected, double riskScore, String reason) {
        this.fraudDetected = fraudDetected;
        this.riskScore = riskScore;
        this.reason = reason;
        this.riskLevel = calculateRiskLevel(riskScore);
        this.requiresManualReview = riskScore > 0.7;
    }

    private String calculateRiskLevel(double score) {
        if (score < 0.3) return "LOW";
        if (score < 0.7) return "MEDIUM";
        return "HIGH";
    }
}

