package com.api.integration.factory;

import com.api.domain.models.Logistic;
import com.api.domain.utils.enums.TypeLogistic;

public class LogisticFactory {

    public static Logistic createLogistic() {
        Logistic logistic = new Logistic();
        logistic.setTypeDelivery(TypeLogistic.valueOf("LAND"));
        logistic.setDeliveryDeposit(DeliveryDepositFactory.deliveryDeposit());
        logistic.setShippingPrice(10.99);
        logistic.setDiscountedPrice(9.99f);
        return logistic;
    }

}
