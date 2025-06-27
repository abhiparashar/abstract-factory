package com.remittance.factory.interfaces;

import com.remittance.factory.PaymentResult;
import com.remittance.model.RemittanceTransaction;
import java.math.BigDecimal;

public interface PaymentGateway {
    PaymentResult processPayment(RemittanceTransaction transaction);
    String generateTrackingNumber();
    boolean validatePayment(BigDecimal amount, String currency);
}
