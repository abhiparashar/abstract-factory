package com.remittance.strategy.impl.notification;

import com.remittance.dto.NotificationResult;
import com.remittance.model.RemittanceTransaction;
import com.remittance.strategy.interfaces.NotificationStrategy;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("pushNotificationStrategy")
public class PushNotificationStrategy implements NotificationStrategy {
    @Override
    public NotificationResult notifySender(String senderId, String message, RemittanceTransaction transaction) {
        return NotificationResult.builder()
                .success(true)
                .message("Push notification sent")
                .notificationId("PUSH-" + UUID.randomUUID().toString().substring(0, 8))
                .deliveryStatus("DELIVERED")
                .channel("PUSH")
                .build();
    }

    @Override
    public NotificationResult notifyRecipient(String recipientId, String message, RemittanceTransaction transaction) {
        return NotificationResult.builder()
                .success(true)
                .message("Push notification sent")
                .notificationId("PUSH-" + UUID.randomUUID().toString().substring(0, 8))
                .deliveryStatus("DELIVERED")
                .channel("PUSH")
                .build();
    }

    @Override
    public String getNotificationMethod() {
        return "PUSH";
    }

    @Override
    public boolean isRealTime() {
        return true;
    }

    @Override
    public boolean supportsRichContent() {
        return true;
    }
}
