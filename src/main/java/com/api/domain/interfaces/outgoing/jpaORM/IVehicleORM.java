package com.api.domain.interfaces.outgoing.jpaORM;

import com.api.domain.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleORM extends JpaRepository<Vehicle, Long>{
    
}
