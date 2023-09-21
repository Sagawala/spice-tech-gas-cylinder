package com.spicetech.gascylinderapp.Entity;

public enum UserRole {
    CUSTOMER("Customer"),
    SUPPLIER("Supplier");

    private final String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
