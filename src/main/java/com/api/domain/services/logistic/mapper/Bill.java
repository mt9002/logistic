package com.api.domain.services.logistic.mapper;

import lombok.Data;

@Data
public class Bill {

    private Double total;
    private int quantityProduct;
    private boolean shippingDiscount;

    public Bill(Double total, int quantityProduct, boolean shippingDiscount) {
        this.total = total;
        this.quantityProduct = quantityProduct;
        this.shippingDiscount = shippingDiscount;
    }
    
    
}
