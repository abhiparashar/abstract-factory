package com.remittance.factory;

public interface PaymentGateway {
    void processPayment();
    String generateTrackingNumber();
    boolean validatePayment();
}
