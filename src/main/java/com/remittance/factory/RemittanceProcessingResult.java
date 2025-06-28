package com.remittance.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemittanceProcessingResult {
    private boolean success;
    private String message;
    private FraudCheckResult fraudResult;
    private ComplianceResult complianceResult;
    private PaymentResult paymentResult;

    public RemittanceProcessingResult(boolean b, String s) {
    }
}
