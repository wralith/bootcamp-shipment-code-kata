package com.trendyol.shipment;

public enum ShipmentSize {

    SMALL,
    MEDIUM,
    LARGE,
    X_LARGE;

    public int getNumberRepresentation() {
        return this.ordinal();
    }

    public ShipmentSize getOneSizeLarger() {
        if (this == X_LARGE) {
            return X_LARGE;
        }
        return values()[this.ordinal() + 1];
    }
}