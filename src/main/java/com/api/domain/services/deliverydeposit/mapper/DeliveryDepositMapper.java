package com.api.domain.services.deliverydeposit.mapper;

import com.api.app.dto.DeliveryDepositDTO;
import com.api.app.dto.DeliveryDepositVehicleDTO;
import com.api.domain.interfaces.outgoing.mapper.IDeliveryDepositMapper;
import com.api.domain.models.deposit.DeliveryDeposit;
import com.api.domain.models.deposit.DeliveryDepositVehicle;
import com.api.domain.models.Vehicle;
import com.api.domain.utils.enums.DeliveryDepositType;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class DeliveryDepositMapper implements IDeliveryDepositMapper{
    
    @Override
    public DeliveryDeposit createMapper(DeliveryDepositDTO deliveryDepositDTO){
        
        DeliveryDeposit deliveryDeposit= new DeliveryDeposit();
        deliveryDeposit.setDeliveryDepositType(DeliveryDepositType.valueOf(deliveryDepositDTO.getTypeDelivery()));
        deliveryDeposit.setName(deliveryDepositDTO.getName());
        
        Set<DeliveryDepositVehicle> setDeliveryDepositVehicle = new HashSet<>();        
        
        if (deliveryDepositDTO.getDeliveryDepositVehicleId()!= null && !deliveryDepositDTO.getDeliveryDepositVehicleId().isEmpty()) {
            for (DeliveryDepositVehicleDTO dpVehicle : deliveryDepositDTO.getDeliveryDepositVehicleId()) {
                
                DeliveryDepositVehicle deliveryDepositVehicle = new DeliveryDepositVehicle(); 
                
                Vehicle vehicle = new Vehicle();
                vehicle.setId(dpVehicle.getVehicleId());
                
                deliveryDepositVehicle.setVehicle(vehicle);
                
                setDeliveryDepositVehicle.add(deliveryDepositVehicle);
            }
        }
        deliveryDeposit.setDeliveryDepositVehicle(setDeliveryDepositVehicle);     
        return deliveryDeposit;
    }
    public DeliveryDeposit updateMapper(DeliveryDepositDTO deliveryDepositDTO, DeliveryDeposit updatedDeliveryDeposit){

        if (deliveryDepositDTO.getTypeDelivery() != null) {
            String deliveryDepositType = deliveryDepositDTO.getTypeDelivery();
            updatedDeliveryDeposit.setDeliveryDepositType(DeliveryDepositType.valueOf(deliveryDepositType));
        }

        if (deliveryDepositDTO.getName()!= null) {
            updatedDeliveryDeposit.setName(deliveryDepositDTO.getName());
        }

        return updatedDeliveryDeposit;
    
    }  
}
