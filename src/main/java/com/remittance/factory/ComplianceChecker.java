package com.remittance.factory;

public interface ComplianceChecker {
    void checkAMLCompliance();
    void checkSanctionsList();
    void getTransactionLimit();
}
