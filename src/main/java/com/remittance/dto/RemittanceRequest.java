package com.remittance.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemittanceRequest {
    @NotBlank(message = "Sender ID is required")
    private String senderId;

    @NotBlank(message = "Recipient ID is required")
    private String recipientId;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "1.0", message = "Amount must be at least 1.0")
    @DecimalMax(value = "50000.0", message = "Amount cannot exceed 50,000")
    private String amount;

    @NotBlank(message = "From currency is required")
    @Size(min = 3, max = 3, message = "Currency code must be 3 characters")
    private String fromCurrency;

    @NotBlank(message = "To currency is required")
    @Size(min = 3, max = 3, message = "Currency code must be 3 characters")
    private String toCurrency;

    @NotBlank(message = "From country is required")
    private String fromCountry;

    @NotBlank(message = "To country is required")
    private String toCountry;

    @NotBlank(message = "Provider ID is required")
    private String providerId;

    private String feeStrategy = "TIERED"; // Default
    private String rateStrategy = "COMPETITIVE"; // Default
    private String deliveryMethod = "BANK_TRANSFER"; // Default
    private String notificationMethod = "EMAIL"; // Default
}
