package com.api.app.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;


public class LogisticDTO {

    public LogisticDTO(String typeDelivery, List<ProductQuantityDTO> productQuantities, Double shippingPrice, Float discountedPrice, Long deliveryDepositId) {
        this.typeDelivery = typeDelivery;
        this.productQuantities = productQuantities;
        this.shippingPrice = shippingPrice;
        this.discountedPrice = discountedPrice;
        this.deliveryDepositId = deliveryDepositId;
    }

    public LogisticDTO() {
    }

    private Long id;
    
    @NotNull(message = "'typeDelivery' no puede ser nulo.")
    private String typeDelivery;
    private List<ProductQuantityDTO> productQuantities; 
    private Double shippingPrice;
    private Float discountedPrice;
    
    private Long deliveryDepositId;
    
    private Long poductId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeDelivery() {
        return typeDelivery;
    }

    public void setTypeDelivery(String typeDelivery) {
        this.typeDelivery = typeDelivery;
    }

    public List<ProductQuantityDTO> getProductQuantities() {
        return productQuantities;
    }

    public void setProductQuantities(List<ProductQuantityDTO> productQuantities) {
        this.productQuantities = productQuantities;
    }

    public Double getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(Double shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public Float getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Float discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public Long getDeliveryDepositId() {
        return deliveryDepositId;
    }

    public void setDeliveryDepositId(Long deliveryDepositId) {
        this.deliveryDepositId = deliveryDepositId;
    }

    public Long getPoductId() {
        return poductId;
    }

    public void setPoductId(Long poductId) {
        this.poductId = poductId;
    }    
} 