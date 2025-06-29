package com.remittance.strategy.interfaces;

import com.remittance.dto.NotificationResult;
import com.remittance.model.RemittanceTransaction;

public interface NotificationStrategy {
    NotificationResult notifySender(String senderId, String message, RemittanceTransaction transaction);
    NotificationResult notifyRecipient(String recipientId, String message, RemittanceTransaction transaction);
    String getNotificationMethod();
    boolean isRealTime();
    boolean supportsRichContent();
}
