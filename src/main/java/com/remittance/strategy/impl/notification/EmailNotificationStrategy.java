package com.remittance.strategy.impl.notification;

import com.remittance.dto.NotificationResult;
import com.remittance.model.RemittanceTransaction;
import com.remittance.strategy.interfaces.NotificationStrategy;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("emailNotificationStrategy")
public class EmailNotificationStrategy implements NotificationStrategy {
    @Override
    public NotificationResult notifySender(String senderId, String message, RemittanceTransaction transaction) {
        return NotificationResult.builder()
                .success(true)
                .message("Email sent successfully")
                .notificationId("EMAIL-" + UUID.randomUUID().toString().substring(0, 8))
                .channel("EMAIL")
                .deliveryStatus("SENT")
                .build();
    }

    @Override
    public NotificationResult notifyRecipient(String recipientId, String message, RemittanceTransaction transaction) {
        return NotificationResult.builder()
                .success(true)
                .message("Email sent successfully")
                .notificationId("EMAIL-" + UUID.randomUUID().toString().substring(0, 8))
                .channel("EMAIL")
                .deliveryStatus("SENT")
                .build();
    }

    @Override
    public String getNotificationMethod() {
        return "EMAIL";
    }

    @Override
    public boolean isRealTime() {
        return false;
    }

    @Override
    public boolean supportsRichContent() {
        return true;
    }
}
