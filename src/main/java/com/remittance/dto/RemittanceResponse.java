package com.remittance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemittanceResponse {
    private String transactionId;
    private String status;
    private String amount;
    private String fee;
    private String totalCost;
    private BigDecimal exchangeRate;
    private BigDecimal convertedAmount;
    private String fromCurrency;
    private String toCurrency;
    private String pickupCode;
    private String estimatedDeliveryMinutes;
    private String message;
}
