package com.api.domain.models.deposit;

import com.api.domain.utils.enums.DeliveryDepositType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Entity
public class DeliveryDeposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private DeliveryDepositType deliveryDepositType;
    
    @OneToMany(mappedBy = "deliveryDeposit",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DeliveryDepositVehicle> deliveryDepositVehicle;
    
    private String name;

    public DeliveryDeposit(DeliveryDepositType deliveryDepositType, Set<DeliveryDepositVehicle> deliveryDepositVehicle, String name) {
        this.deliveryDepositType = deliveryDepositType;
        this.deliveryDepositVehicle = deliveryDepositVehicle;
        this.name = name;
    }

    public DeliveryDeposit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeliveryDepositType getDeliveryDepositType() {
        return deliveryDepositType;
    }

    public void setDeliveryDepositType(DeliveryDepositType deliveryDepositType) {
        this.deliveryDepositType = deliveryDepositType;
    }

    public Set<DeliveryDepositVehicle> getDeliveryDepositVehicle() {
        return deliveryDepositVehicle;
    }

    public void setDeliveryDepositVehicle(Set<DeliveryDepositVehicle> deliveryDepositVehicle) {
        this.deliveryDepositVehicle = deliveryDepositVehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
