package com.remittance.service;

import com.remittance.strategy.impl.delivery.BankTransferStrategy;
import com.remittance.strategy.impl.delivery.CashPickupStrategy;
import com.remittance.strategy.impl.delivery.HomeDeliveryStrategy;
import com.remittance.strategy.impl.delivery.MobileWalletStrategy;
import com.remittance.strategy.impl.fee.FixedFeeStrategy;
import com.remittance.strategy.impl.fee.PercentageFeeStrategy;
import com.remittance.strategy.impl.fee.PromotionalFeeStrategy;
import com.remittance.strategy.impl.fee.TieredFeeStrategy;
import com.remittance.strategy.impl.notification.EmailNotificationStrategy;
import com.remittance.strategy.impl.notification.MultiChannelNotificationStrategy;
import com.remittance.strategy.impl.notification.PushNotificationStrategy;
import com.remittance.strategy.impl.notification.SMSNotificationStrategy;
import com.remittance.strategy.impl.rate.BankRateStrategy;
import com.remittance.strategy.impl.rate.CompetitiveRateStrategy;
import com.remittance.strategy.impl.rate.MidMarketRateStrategy;
import com.remittance.strategy.interfaces.DeliveryStrategy;
import com.remittance.strategy.interfaces.ExchangeRateStrategy;
import com.remittance.strategy.interfaces.FeeCalculationStrategy;
import com.remittance.strategy.interfaces.NotificationStrategy;

import java.util.ArrayList;
import java.util.List;

public class StrategyService {
    private final BankTransferStrategy bankTransferStrategy;
    private final CashPickupStrategy cashPickupStrategy;
    private final HomeDeliveryStrategy homeDeliveryStrategy;
    private final MobileWalletStrategy mobileWalletStrategy;
    private final FixedFeeStrategy fixedFeeStrategy;
    private final PercentageFeeStrategy percentageFeeStrategy;
    private final PromotionalFeeStrategy promotionalFeeStrategy;
    private final TieredFeeStrategy tieredFeeStrategy;
    private final EmailNotificationStrategy emailNotificationStrategy;
    private final MultiChannelNotificationStrategy multiChannelNotificationStrategy;
    private final PushNotificationStrategy pushNotificationStrategy;
    private final SMSNotificationStrategy smsNotificationStrategy;
    private final BankRateStrategy bankRateStrategy;
    private final CompetitiveRateStrategy competitiveRateStrategy;
    private final MidMarketRateStrategy midMarketRateStrategy;

    StrategyService(BankTransferStrategy bankTransferStrategy, CashPickupStrategy cashPickupStrategy, HomeDeliveryStrategy homeDeliveryStrategy, MobileWalletStrategy mobileWalletStrategy, FixedFeeStrategy fixedFeeStrategy, PercentageFeeStrategy percentageFeeStrategy, PromotionalFeeStrategy promotionalFeeStrategy, TieredFeeStrategy tieredFeeStrategy, EmailNotificationStrategy emailNotificationStrategy, MultiChannelNotificationStrategy multiChannelNotificationStrategy, PushNotificationStrategy pushNotificationStrategy, SMSNotificationStrategy smsNotificationStrategy, BankRateStrategy bankRateStrategy, CompetitiveRateStrategy competitiveRateStrategy, MidMarketRateStrategy midMarketRateStrategy){
        this.bankTransferStrategy = bankTransferStrategy;
        this.cashPickupStrategy = cashPickupStrategy;
        this.homeDeliveryStrategy = homeDeliveryStrategy;
        this.mobileWalletStrategy = mobileWalletStrategy;
        this.fixedFeeStrategy = fixedFeeStrategy;
        this.percentageFeeStrategy = percentageFeeStrategy;
        this.promotionalFeeStrategy = promotionalFeeStrategy;
        this.tieredFeeStrategy = tieredFeeStrategy;
        this.emailNotificationStrategy = emailNotificationStrategy;
        this.multiChannelNotificationStrategy = multiChannelNotificationStrategy;
        this.pushNotificationStrategy = pushNotificationStrategy;
        this.smsNotificationStrategy = smsNotificationStrategy;
        this.bankRateStrategy = bankRateStrategy;
        this.competitiveRateStrategy = competitiveRateStrategy;
        this.midMarketRateStrategy = midMarketRateStrategy;
    }

    public FeeCalculationStrategy getFeeStrategy(String strategyType) {
        return switch (strategyType.toUpperCase()) {
            case "FIXED" -> {
                yield fixedFeeStrategy;
            }
            case "PERCENTAGE" -> {
                yield percentageFeeStrategy;
            }
            case "TIERED" -> {
                yield tieredFeeStrategy;
            }
            case "PROMOTIONAL" -> {
                yield promotionalFeeStrategy;
            }
            default -> {
                throw new IllegalArgumentException("Unknown strategy type: " + strategyType);
            }
        };
    }

    public ExchangeRateStrategy getExchangeRate(String strategyType){
       return switch (strategyType.toUpperCase()){
           case "BANK" -> {
               yield bankRateStrategy;
           }
           case "COMPETITIVE" -> {
               yield competitiveRateStrategy;
           }
           case "MID_MARKET" -> {
               yield midMarketRateStrategy;
           }
           default -> {
               throw new IllegalArgumentException("Unknown strategy type: " + strategyType);
           }
       };
    }

    public DeliveryStrategy getDeliveryStrategy(String strategyType) {
        switch (strategyType.toUpperCase()) {
            case "CASH_PICKUP":
                return cashPickupStrategy;
            case "BANK_TRANSFER":
                return bankTransferStrategy;
            case "MOBILE_WALLET":
                return mobileWalletStrategy;
            case "HOME_DELIVERY":
                return homeDeliveryStrategy;
            default:
                return bankTransferStrategy; // Default
        }
    }

    public NotificationStrategy getNotificationStrategy(String strategyType) {
        switch (strategyType.toUpperCase()) {
            case "EMAIL":
                return emailNotificationStrategy;
            case "SMS":
                return smsNotificationStrategy;
            case "PUSH":
                return pushNotificationStrategy;
            case "MULTI_CHANNEL":
                return multiChannelNotificationStrategy;
            default:
                return emailNotificationStrategy; // Default
        }
    }

    public List<String> getAvailableDeliveryMethods(String country) {
        List<String> availableMethods = new ArrayList<>();

        if (cashPickupStrategy.isAvailableInCountry(country)) {
            availableMethods.add("CASH_PICKUP");
        }
        if (bankTransferStrategy.isAvailableInCountry(country)) {
            availableMethods.add("BANK_TRANSFER");
        }
        if (mobileWalletStrategy.isAvailableInCountry(country)) {
            availableMethods.add("MOBILE_WALLET");
        }
        if (homeDeliveryStrategy.isAvailableInCountry(country)) {
            availableMethods.add("HOME_DELIVERY");
        }

        return availableMethods;
    }
}
