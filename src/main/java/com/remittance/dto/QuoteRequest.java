package com.remittance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuoteRequest {
    @NotNull
    @DecimalMin("1.0")
    private BigDecimal amount;

    @NotBlank
    private String fromCurrency;

    @NotBlank
    private String toCurrency;

    @NotBlank
    private String fromCountry;

    @NotBlank
    private String toCountry;

    @NotBlank
    private String providerId;

    private String feeStrategy = "TIERED";
    private String rateStrategy = "COMPETITIVE";
}
