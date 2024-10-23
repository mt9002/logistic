package com.api.app.dto;

import java.util.List;

public class DeliveryDepositDTO {
    private String typeDelivery;
    private String name;
    private List<DeliveryDepositVehicleDTO> deliveryDepositVehicleId;

    public List<DeliveryDepositVehicleDTO> getDeliveryDepositVehicleId() {
        return deliveryDepositVehicleId;
    }

    public void setDeliveryDepositVehicleId(List<DeliveryDepositVehicleDTO> deliveryDepositVehicleId) {
        this.deliveryDepositVehicleId = deliveryDepositVehicleId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public String getTypeDelivery() {
        return typeDelivery;
    }

    public void setTypeDelivery(String typeDelivery) {
        this.typeDelivery = typeDelivery;
    }
    
    
}
