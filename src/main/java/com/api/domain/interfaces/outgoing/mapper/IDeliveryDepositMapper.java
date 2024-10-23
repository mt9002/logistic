package com.api.domain.interfaces.outgoing.mapper;

import com.api.app.dto.DeliveryDepositDTO;
import com.api.domain.models.deposit.DeliveryDeposit;

public interface IDeliveryDepositMapper {
    DeliveryDeposit createMapper(DeliveryDepositDTO deliveryDeposit);
    DeliveryDeposit updateMapper(DeliveryDepositDTO deliveryDeposit, DeliveryDeposit updatedDeliveryDeposit);
}
