package com.remittance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationResult {
    private boolean success;
    private String notificationId;
    private String channel;
    private String message;
    private String deliveryStatus; // SENT, DELIVERED, FAILED, PENDING

    public NotificationResult(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.deliveryStatus = success ? "SENT" : "FAILED";
    }
}
