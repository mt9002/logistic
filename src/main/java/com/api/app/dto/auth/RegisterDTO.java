package com.api.app.dto.auth;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {
    String userName;
    String password;
    String firstName;
    String lastName;
    String country; 
    
    @NotNull(message = "'email' no puede ser nulo.")
    String email;
}
