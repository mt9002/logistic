package com.api.domain.models;

import com.api.domain.models.product.ProductQuantity;
import com.api.domain.models.deposit.DeliveryDeposit;
import com.api.domain.utils.enums.TypeLogistic;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;

import java.util.Set;

@Entity
public class Logistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeLogistic typeDelivery;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "logistic", cascade = CascadeType.ALL)
    private Set<ProductQuantity> productQuantities = new HashSet<>();

    @ManyToOne
    private DeliveryDeposit deliveryDeposit;

    private Double shippingPrice;
    private Float discountedPrice;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date registrationDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime fechaEntrega;

    @PrePersist
    public void setFechaRegistro() {
        this.registrationDate = new Date();
    }

    public void setFechaEntregaDay(long day) {
        this.fechaEntrega = fechaEntrega.plusDays(day);
    }

    public Logistic() {
        this.fechaEntrega = LocalDateTime.now();
    }

    public Logistic(TypeLogistic typeDelivery,
            Set<ProductQuantity> productQuantities,
            DeliveryDeposit deliveryDeposit,
            Double shippingPrice,
            Float discountedPrice) {
        this.typeDelivery = typeDelivery;
        this.productQuantities = productQuantities;
        this.deliveryDeposit = deliveryDeposit;
        this.shippingPrice = shippingPrice;
        this.discountedPrice = discountedPrice;
        this.fechaEntrega = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeLogistic getTypeDelivery() {
        return typeDelivery;
    }

    public void setTypeDelivery(TypeLogistic typeDelivery) {
        this.typeDelivery = typeDelivery;
    }

    public Set<ProductQuantity> getProductQuantities() {
        return productQuantities;
    }

    public void setProductQuantities(Set<ProductQuantity> productQuantities) {
        this.productQuantities = productQuantities;
    }

    public DeliveryDeposit getDeliveryDeposit() {
        return deliveryDeposit;
    }

    public void setDeliveryDeposit(DeliveryDeposit deliveryDeposit) {
        this.deliveryDeposit = deliveryDeposit;
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

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

}
