package com.cbcode.loja_virtual_mentoria.enums;

public enum AccountsPaymentStatus {

    BILLING("Billing"), // Billing is the status when the billing account is created but no payment has been made yet
    OVERDUE("Overdue"), // Overdue is the status when the payment is overdue and the account is blocked until the payment is made
    OPEN("Open"), // Open is the status when the payment is made and the account is active
    PAID("Paid"), // Paid is the status when the payment is made and the account is active
    RENEGOTIATED("Renegotiated"); // Renegotiated is the status when the payment is renegotiated and the account is active

    private String description;

    AccountsPaymentStatus(String description) {
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
