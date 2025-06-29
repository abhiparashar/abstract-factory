package com.remittance.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryResult {
    private boolean success;
    private String deliveryCode;
    private String trackingNumber;
    private int estimatedDeliveryMinutes;
    private String message;
    private String deliveryInstructions;
}
