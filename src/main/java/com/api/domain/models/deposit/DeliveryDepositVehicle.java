package com.api.domain.models.deposit;

import com.api.domain.models.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DeliveryDepositVehicle {

    public DeliveryDepositVehicle(DeliveryDeposit deliveryDeposit, Vehicle vehicle) {
        this.deliveryDeposit = deliveryDeposit;
        this.vehicle = vehicle;
    }
    
    public DeliveryDepositVehicle(){};
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_deposit_id")
    @JsonIgnore
    private DeliveryDeposit deliveryDeposit;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeliveryDeposit getDeliveryDeposit() {
        return deliveryDeposit;
    }

    public void setDeliveryDeposit(DeliveryDeposit deliveryDeposit) {
        this.deliveryDeposit = deliveryDeposit;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    
    
}