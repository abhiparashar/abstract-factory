package com.remittance.strategy.impl.notification;

import com.remittance.dto.NotificationResult;
import com.remittance.model.RemittanceTransaction;
import com.remittance.strategy.interfaces.NotificationStrategy;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("smsNotificationStrategy")
public class SMSNotificationStrategy implements NotificationStrategy {
    @Override
    public NotificationResult notifySender(String senderId, String message, RemittanceTransaction transaction) {
        return NotificationResult.builder()
                .success(true)
                .message("SMS sent successfully")
                .channel("SMS")
                .notificationId("SMS-" + UUID.randomUUID().toString().substring(0, 6))
                .deliveryStatus("DELIVERED")
                .build();
    }

    @Override
    public NotificationResult notifyRecipient(String recipientId, String message, RemittanceTransaction transaction) {
        return NotificationResult.builder()
                .success(true)
                .message("SMS sent successfully")
                .notificationId("SMS-" + UUID.randomUUID().toString().substring(0, 6))
                .channel("SMS")
                .deliveryStatus("DELIVERED")
                .build();
    }

    @Override
    public String getNotificationMethod() {
        return "SMS";
    }

    @Override
    public boolean isRealTime() {
        return true;
    }

    @Override
    public boolean supportsRichContent() {
        return false;
    }
}
