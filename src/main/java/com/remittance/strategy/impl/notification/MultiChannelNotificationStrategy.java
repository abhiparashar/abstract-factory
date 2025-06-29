package com.remittance.strategy.impl.notification;

import com.remittance.dto.NotificationResult;
import com.remittance.model.RemittanceTransaction;
import com.remittance.strategy.interfaces.NotificationStrategy;
import org.springframework.stereotype.Component;

@Component("multiChannelNotificationStrategy")
public class MultiChannelNotificationStrategy implements NotificationStrategy {
    private final EmailNotificationStrategy emailNotificationStrategy;
    private final SMSNotificationStrategy smsNotificationStrategy;
    private final PushNotificationStrategy pushNotificationStrategy;

    public MultiChannelNotificationStrategy(EmailNotificationStrategy emailNotificationStrategy, SMSNotificationStrategy smsNotificationStrategy, PushNotificationStrategy pushNotificationStrategy){
        this.emailNotificationStrategy = emailNotificationStrategy;
        this.smsNotificationStrategy = smsNotificationStrategy;
        this.pushNotificationStrategy = pushNotificationStrategy;
    }
    @Override
    public NotificationResult notifySender(String senderId, String message, RemittanceTransaction transaction) {
        emailNotificationStrategy.notifySender(senderId,message,transaction);
        smsNotificationStrategy.notifySender(senderId,message,transaction);
        pushNotificationStrategy.notifySender(senderId,message,transaction);

        return NotificationResult.builder()
                .success(true)
                .message("Multi-channel notifications sent")
                .channel("MULTI_CHANNEL")
                .deliveryStatus("SENT")
                .build();
    }

    @Override
    public NotificationResult notifyRecipient(String recipientId, String message, RemittanceTransaction transaction) {
        emailNotificationStrategy.notifyRecipient(recipientId,message,transaction);
        smsNotificationStrategy.notifyRecipient(recipientId,message,transaction);
        pushNotificationStrategy.notifyRecipient(recipientId,message,transaction);

        return NotificationResult.builder()
                .success(true)
                .message("Multi-channel notifications sent")
                .channel("MULTI_CHANNEL")
                .deliveryStatus("SENT")
                .build();
    }

    @Override
    public String getNotificationMethod() {
        return "MULTI_CHANNEL";
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
