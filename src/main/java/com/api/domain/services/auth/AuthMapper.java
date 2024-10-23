package com.api.domain.services.auth;

import com.api.app.dto.auth.RegisterDTO;
import com.api.domain.interfaces.outgoing.mapper.IAuthMapper;
import com.api.domain.models.auth.Role;
import com.api.domain.models.auth.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper implements IAuthMapper {
    
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public AuthMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    public Client DtoToEntity(RegisterDTO registerRequestDTO) {
        Client Client = new Client(
               registerRequestDTO.getUserName(),
               registerRequestDTO.getFirstName(),
               registerRequestDTO.getEmail(),
               passwordEncoder.encode(registerRequestDTO.getPassword())      
        );
        Client.setRole(Role.valueOf("USER"));
        return Client;
    }

}
