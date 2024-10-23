package com.api.integration.factory;

import com.api.domain.models.Vehicle;
import com.api.domain.utils.enums.VehicleIdentifierType;

public class VehicleFactory {
    public static Vehicle vehicle(){
        Vehicle vehicle = new Vehicle(
                VehicleIdentifierType.valueOf("PLACA"),
                "VAZ133",
                "Kia"
        );
        return vehicle;
    }
}
