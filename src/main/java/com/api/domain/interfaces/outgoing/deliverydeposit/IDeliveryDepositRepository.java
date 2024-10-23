package com.api.domain.interfaces.outgoing.deliverydeposit;

import com.api.app.dto.DeliveryDepositDTO;
import com.api.app.dto.Response;

public interface IDeliveryDepositRepository {
    Response createDeliveryDeposit(DeliveryDepositDTO dto);
    Response getByIdDeliveryDeposit(Long id);
    Response updateDeliveryDeposit(Long id, DeliveryDepositDTO dto);
    Response deleteDeliveryDeposit(Long id);
}
