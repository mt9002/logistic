package com.api.domain.interfaces.outgoing.jpaORM;

import com.api.domain.models.deposit.DeliveryDeposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeliveryDepositORM extends JpaRepository<DeliveryDeposit, Long>{
    
}
