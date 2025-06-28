package com.remittance.strategy.interfaces;

public interface NotificationStrategy {
    void notifySender();
    void notifyRecipient();
    void getNotificationMethod();
}
