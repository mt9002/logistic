package com.api.domain.services.auth;

import com.api.app.dto.Response;
import com.api.app.dto.auth.LoginRequestDTO;
import com.api.app.dto.auth.RegisterDTO;
import com.api.domain.interfaces.incoming.IAuthService;
import com.api.domain.interfaces.outgoing.auth.IAuthRepository;
import com.api.domain.models.auth.Client;
import com.api.domain.interfaces.outgoing.auth.IJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    private final IAuthRepository iAuthRepository;
    private final IJWT iJWT;

    @Autowired
    public AuthService(IAuthRepository iAuthRepository, IJWT iJWT) {
        this.iAuthRepository = iAuthRepository;
        this.iJWT = iJWT;
    }

    @Override
    public Response Login(LoginRequestDTO loginRequestDTO) {

        try {
            String email = loginRequestDTO.getEmail();
            String password = loginRequestDTO.getPassword();

            Response<Authentication> response = iAuthRepository.login(email, password);
            
            if (response.getData() == null) {
                return response;
            }

            Client user = (Client) response.getData().getPrincipal();
            String token = iJWT.getToken(user);

            return new Response(
                    response.getMessage(),
                    response.getStatus(),
                    true,
                    token
            );
        } catch (Exception e) {
            return new Response(
                    "token not found" + e.getMessage(),
                    HttpStatus.UNAUTHORIZED.value(),
                    false,
                    null
            );
        }

    }

    @Override
    public Response<String> Register(RegisterDTO registerRequestDTO) {
        Response<Client> response = iAuthRepository.register(registerRequestDTO);

        Client user = response.getData();
        String token = iJWT.getToken(user);
        return new Response(
                response.getMessage(),
                response.getStatus(),
                true,
                token
        );
    }

}
