package com.api.domain.interfaces.incoming;

import com.api.app.dto.DeliveryDepositDTO;
import com.api.app.dto.Response;

public interface IDeliveryDepositService {
    Response createDeliveryDeposit(DeliveryDepositDTO dto);
    Response getByIdDeliveryDeposit(Long id);
    Response updateDeliveryDeposit(Long id, DeliveryDepositDTO dto);
    Response deleteDeliveryDeposit(Long id);
}
