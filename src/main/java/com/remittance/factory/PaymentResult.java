package com.remittance.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResult {
    private boolean success;
    private String transactionId;
    private String trackingNumber;
    private String providerTransactionId;
    private String message;
    private String errorCode;
}
