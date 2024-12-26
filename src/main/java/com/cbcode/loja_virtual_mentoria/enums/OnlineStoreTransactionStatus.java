package com.cbcode.loja_virtual_mentoria.enums;

/**
 * Represents the status of an online store transaction.
 * This enum is used to define the status of an online store transaction.
 */
public enum OnlineStoreTransactionStatus {

    PENDING("Pending"),
    PAID("Paid"),
    CANCELED("Canceled"),
    REFUNDED("Refunded"),
    ABANDONED_CART("Abandoned Cart");

    private final String description;

    OnlineStoreTransactionStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
