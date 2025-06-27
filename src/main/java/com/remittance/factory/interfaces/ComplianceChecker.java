package com.remittance.factory.interfaces;

import com.remittance.factory.ComplianceResult;
import com.remittance.model.RemittanceTransaction;

import java.math.BigDecimal;

public interface ComplianceChecker {
    ComplianceResult checkAMLCompliance(RemittanceTransaction transaction);
    boolean checkSanctionsList(String customerId, String country);
    BigDecimal getTransactionLimit(String country, String currency);
    boolean requiresAdditionalVerification(BigDecimal amount, String country);
}
