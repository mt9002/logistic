package com.api.integration.factory;

import com.api.domain.models.deposit.DeliveryDeposit;
import com.api.domain.utils.enums.DeliveryDepositType;

public class DeliveryDepositFactory {

    public static DeliveryDeposit deliveryDeposit() {
        DeliveryDeposit deliveryDeposit = new DeliveryDeposit();
        deliveryDeposit.setDeliveryDepositType(DeliveryDepositType.valueOf("PORT"));
        deliveryDeposit.setName("Depósito MariaEugenia");
        return deliveryDeposit;
    }
}
