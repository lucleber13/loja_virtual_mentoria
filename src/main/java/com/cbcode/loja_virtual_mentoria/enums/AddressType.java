package com.cbcode.loja_virtual_mentoria.enums;

public enum AddressType {

    BILLING("Billing"),
    SHIPPING("Shipping");

    private final String description;

    AddressType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
