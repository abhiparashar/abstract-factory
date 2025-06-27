package com.remittance.strategy;

public interface NotificationStrategy {
    void notifySender();
    void notifyRecipient();
    void getNotificationMethod();
}
