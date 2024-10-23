package com.api.domain.interfaces.outgoing.jpaORM;

import com.api.domain.models.auth.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserORM extends JpaRepository<Client, Long>{
    
}
