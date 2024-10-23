package com.api.app.dto;

import jakarta.validation.constraints.Pattern;

public class VehicleDTO {

       
    private Long idVehicle;
    
    @Pattern(regexp = "^[A-Za-z]{3}\\d{3}$", message = "Vehicle plate must be in the format 3 letters followed by 3 numbers")
    private String vehiclePlate;
    
    @Pattern(regexp = "^[A-Za-z]{3}\\d{4}[A-Za-z]$", message = "Fleet number must be in the format 3 letters, 4 numbers, 1 letter")
    private String fleetNumber;   

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getFleetNumber() {
        return fleetNumber;
    }

    public void setFleetNumber(String fleetNumber) {
        this.fleetNumber = fleetNumber;
    }

    public Long getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Long idVehicle) {
        this.idVehicle = idVehicle;
    }
    
    
}
