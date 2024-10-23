package com.api.domain.interfaces.outgoing.jpaORM;

import com.api.domain.models.deposit.DeliveryDepositVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeliveryDepositVehicleORM extends JpaRepository<DeliveryDepositVehicle, Long>{
    
}
