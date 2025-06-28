package com.remittance.factory;

import com.remittance.factory.interfaces.ComplianceChecker;
import com.remittance.factory.interfaces.CurrencyConverter;
import com.remittance.factory.interfaces.FraudDetector;
import com.remittance.factory.interfaces.PaymentGateway;
import com.remittance.model.RemittanceTransaction;

import java.math.BigDecimal;

public abstract class RemittanceProviderFactory {
    public abstract PaymentGateway createPaymentGateway();
    public abstract FraudDetector createFraudDetector();
    public abstract CurrencyConverter createCurrencyConverter();
    public abstract ComplianceChecker createComplianceChecker();

    // Provider identification
    public abstract String getProviderId();
    public abstract String getProviderName();
    public abstract boolean isAvailableInCountry(String country);
    public abstract int getMaxTransactionLimit();

    // Template method for processing complete remittance
    public final RemittanceProcessingResult processRemittance(RemittanceTransaction transaction){
        FraudDetector fraudDetector = createFraudDetector();
        ComplianceChecker compliance = createComplianceChecker();
        CurrencyConverter converter = createCurrencyConverter();
        PaymentGateway gateway = createPaymentGateway();

        // Step 1: Fraud Detection
        FraudCheckResult fraudCheckResult = fraudDetector.detectFraud(transaction);
        if(fraudCheckResult.isFraudDetected()){
            return new RemittanceProcessingResult(false, "Transaction blocked due to fraud detection: " + fraudCheckResult.getReason());
        }

        // Step 2: Compliance Check
        ComplianceResult complianceResult = compliance.checkAMLCompliance(transaction);
        if (!complianceResult.isCompliant()) {
            return new RemittanceProcessingResult(false, "Transaction blocked due to compliance issues: " + complianceResult.getMessage());
        }


        // Step 3: Currency Conversion
        BigDecimal exchangeRate = converter.getExchangeRate(transaction.getFromCurrency(), transaction.getToCurrency());
        BigDecimal convertedAmount = converter.convertCurrency(transaction.getAmount(),
                transaction.getFromCurrency(),
                transaction.getToCurrency());
        transaction.setExchangeRate(exchangeRate);
        transaction.setConvertedAmount(convertedAmount);

        // Step 4: Payment Processing
        PaymentResult paymentResult = gateway.processPayment(transaction);
        if (!paymentResult.isSuccess()) {
            return new RemittanceProcessingResult(false, "Payment processing failed: " + paymentResult.getMessage());
        }

        transaction.setTrackingNumber(paymentResult.getTrackingNumber());

        return new RemittanceProcessingResult(true, "Transaction processed successfully",
                fraudCheckResult, complianceResult, paymentResult);

    }
}
