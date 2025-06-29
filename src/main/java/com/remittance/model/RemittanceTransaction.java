package com.remittance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@Table(name = "remittance_transactions")
public class RemittanceTransaction {

    @Id
    private String transactionId;

    @Column(nullable = false)
    private String senderId;

    @Column(nullable = false)
    private String recipientId;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @Column(nullable = false, length = 3)
    private String fromCurrency;

    @Column(nullable = false, length = 3)
    private String toCurrency;

    @Column(nullable = false)
    private String fromCountry;

    @Column(nullable = false)
    private String toCountry;

    @Column(nullable = false)
    private String providerId; // WESTERN_UNION, MONEYGRAM, WISE

    @Column(nullable = false)
    private String feeStrategy; // FIXED, PERCENTAGE, TIERED

    @Column(nullable = false)
    private String rateStrategy; // BANK, MID_MARKET, COMPETITIVE

    @Column(nullable = false)
    private String deliveryMethod; // CASH_PICKUP, BANK_TRANSFER, MOBILE_WALLET, HOME_DELIVERY

    @Column(nullable = false)
    private String notificationMethod; // EMAIL, SMS, PUSH, MULTI_CHANNEL

    @Column(precision = 19, scale = 4)
    private BigDecimal fee;

    @Column(precision = 19, scale = 6)
    private BigDecimal exchangeRate;

    @Column(precision = 19, scale = 4)
    private BigDecimal convertedAmount;

    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime completedAt;

    private String pickupCode;
    private String trackingNumber;
    private Integer estimatedDeliveryMinutes;

    // Constructors
    public RemittanceTransaction() {
        this.transactionId = generateTransactionId();
        this.createdAt = LocalDateTime.now();
        this.status = TransactionStatusEnum.INITIATED;
    }

    public RemittanceTransaction(String senderId, String recipientId, BigDecimal amount,
                                 String fromCurrency, String toCurrency, String fromCountry,
                                 String toCountry, String providerId) {
        this();
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.amount = amount;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.fromCountry = fromCountry;
        this.toCountry = toCountry;
        this.providerId = providerId;
    }

    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }

    // Getters and Setters
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public String getSenderId() { return senderId; }
    public void setSenderId(String senderId) { this.senderId = senderId; }

    public String getRecipientId() { return recipientId; }
    public void setRecipientId(String recipientId) { this.recipientId = recipientId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getFromCurrency() { return fromCurrency; }
    public void setFromCurrency(String fromCurrency) { this.fromCurrency = fromCurrency; }

    public String getToCurrency() { return toCurrency; }
    public void setToCurrency(String toCurrency) { this.toCurrency = toCurrency; }

    public String getFromCountry() { return fromCountry; }
    public void setFromCountry(String fromCountry) { this.fromCountry = fromCountry; }

    public String getToCountry() { return toCountry; }
    public void setToCountry(String toCountry) { this.toCountry = toCountry; }

    public String getProviderId() { return providerId; }
    public void setProviderId(String providerId) { this.providerId = providerId; }

    public String getFeeStrategy() { return feeStrategy; }
    public void setFeeStrategy(String feeStrategy) { this.feeStrategy = feeStrategy; }

    public String getRateStrategy() { return rateStrategy; }
    public void setRateStrategy(String rateStrategy) { this.rateStrategy = rateStrategy; }

    public String getDeliveryMethod() { return deliveryMethod; }
    public void setDeliveryMethod(String deliveryMethod) { this.deliveryMethod = deliveryMethod; }

    public String getNotificationMethod() { return notificationMethod; }
    public void setNotificationMethod(String notificationMethod) { this.notificationMethod = notificationMethod; }

    public BigDecimal getFee() { return fee; }
    public void setFee(BigDecimal fee) { this.fee = fee; }

    public BigDecimal getExchangeRate() { return exchangeRate; }
    public void setExchangeRate(BigDecimal exchangeRate) { this.exchangeRate = exchangeRate; }

    public BigDecimal getConvertedAmount() { return convertedAmount; }
    public void setConvertedAmount(BigDecimal convertedAmount) { this.convertedAmount = convertedAmount; }

    public TransactionStatusEnum getStatus() { return status; }
    public void setStatus(TransactionStatusEnum status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();
        if (status == TransactionStatusEnum.COMPLETED) {
            this.completedAt = LocalDateTime.now();
        }
    }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public LocalDateTime getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }

    public String getPickupCode() { return pickupCode; }
    public void setPickupCode(String pickupCode) { this.pickupCode = pickupCode; }

    public String getTrackingNumber() { return trackingNumber; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }

    public Integer getEstimatedDeliveryMinutes() { return estimatedDeliveryMinutes; }
    public void setEstimatedDeliveryMinutes(Integer estimatedDeliveryMinutes) {
        this.estimatedDeliveryMinutes = estimatedDeliveryMinutes;
    }
}

// Transaction Status Enum
enum TransactionStatusEnum {
    INITIATED,
    FRAUD_CHECK_PENDING,
    COMPLIANCE_CHECK_PENDING,
    PAYMENT_PROCESSING,
    PAYMENT_COMPLETED,
    DELIVERY_IN_PROGRESS,
    COMPLETED,
    FAILED,
    CANCELLED
}
