package com.api.integration.factory;

import com.api.domain.models.Dispatch;

public class DispatchFactory {

    public static Dispatch createDispatch() {
        Dispatch dispatch = new Dispatch();
        dispatch.setClient(UserFactory.createUser());
        dispatch.setLogistic(LogisticFactory.createLogistic());
        dispatch.setGuideNumber("GUI-12345");
        return dispatch;
    }
}
