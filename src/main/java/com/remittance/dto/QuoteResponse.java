package com.remittance.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuoteResponse {
    private BigDecimal fee;
    private BigDecimal exchangeRate;
    private BigDecimal convertedAmount;
    private BigDecimal totalCost;
    private Integer estimatedDeliveryMinutes;
    private String providerId;
    private String feeDescription;
    private String rateSource;
}
