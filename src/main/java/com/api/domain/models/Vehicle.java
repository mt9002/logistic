package com.api.domain.models;

import com.api.domain.utils.enums.VehicleIdentifierType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VehicleIdentifierType identifierType;

    @Column(unique = true)
    private String identifierValue;

    private String brand;

    public Vehicle(VehicleIdentifierType identifierType, String identifierValue, String brand) {
        this.identifierType = identifierType;
        this.identifierValue = identifierValue;
        this.brand = brand;
    }

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehicleIdentifierType getIdentifierType() {
        return identifierType;
    }

    public void setIdentifierType(VehicleIdentifierType identifierType) {
        this.identifierType = identifierType;
    }

    public String getIdentifierValue() {
        return identifierValue;
    }

    public void setIdentifierValue(String identifierValue) {
        this.identifierValue = identifierValue;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
