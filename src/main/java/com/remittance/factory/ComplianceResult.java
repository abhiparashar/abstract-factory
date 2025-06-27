package com.remittance.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplianceResult {
    private boolean compliant;
    private String message;
    private boolean requiresKYC;
    private boolean sanctioned;
    private String complianceLevel; // BASIC, ENHANCED, PREMIUM
}
