package com.cbcode.loja_virtual_mentoria.enums;

/**
 * Represents the type of person.
 * This enum is used to store the type of person.
 */
public enum PersonType {

    PRIVATE_INDIVIDUAL("Private"),
    BUSINESS_PERSON("Business"),
    BUSINESS_SUPPLIER("Supplier");

    private final String description;

    PersonType(String description) {
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
