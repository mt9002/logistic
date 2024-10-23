package com.api.domain.services.utils;

public enum EnumDiscount {
    SEA_DISCOUNT(0.03),
    LAND_DISCOUNT(0.05);
    
     private final double discountValue;

    EnumDiscount(double discountValue) {
        this.discountValue = discountValue;
    }

    // Método para obtener el valor de descuento
    public double getDiscountValue() {
        return discountValue;
    }
}
