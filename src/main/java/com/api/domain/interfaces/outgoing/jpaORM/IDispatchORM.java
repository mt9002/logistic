package com.api.domain.interfaces.outgoing.jpaORM;

import com.api.domain.models.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IDispatchORM extends JpaRepository<Dispatch, Long>{
    
}
