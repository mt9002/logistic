package com.api.domain.interfaces.outgoing.jpaORM;

import com.api.domain.models.auth.Client;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthORM extends JpaRepository<Client, Long>{
    Optional<Client> findByEmail(String email);
}
