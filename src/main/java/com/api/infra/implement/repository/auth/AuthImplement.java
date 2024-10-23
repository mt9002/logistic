package com.api.infra.implement.repository.auth;

import com.api.app.dto.Response;
import com.api.app.dto.auth.LoginRequestDTO;
import com.api.app.dto.auth.RegisterDTO;
import com.api.domain.interfaces.outgoing.auth.IAuthRepository;
import com.api.domain.interfaces.outgoing.jpaORM.IAuthORM;
import com.api.domain.models.auth.Client;
import com.api.domain.services.auth.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AuthImplement implements IAuthRepository {

    private final IAuthORM iAuthORM;
    private final AuthMapper authMapper;
    private final AuthenticationManager authenticationManager;

    @Override
    public Response<Client> register(RegisterDTO registerRequestDTO) {

        try {
            Client user = authMapper.DtoToEntity(registerRequestDTO);
            iAuthORM.save(user);
            return new Response(
                    "usuario Registrado",
                    HttpStatus.OK.value(),
                    true,
                    user);
        } catch (Exception e) {
            return new Response(
                    "usuario no creado " + e,
                    HttpStatus.BAD_REQUEST.value(),
                    false,
                    null);
        }
    }

    @Override
    public Response getByUserEmail(String email) {

        try {
            var user = iAuthORM.findByEmail(email);
            System.out.println(user);
            if (user.isEmpty()) {
                throw new RuntimeException("ID inválido o no econtrado");
            }
            return new Response(
                    "Logistic encontrado",
                    HttpStatus.OK.value(),
                    true,
                    user);
        } catch (RuntimeException e) {
            return new Response(
                    "Logistic no encontrado, " + e.getMessage(),
                    HttpStatus.NOT_FOUND.value(),
                    false,
                    null);
        }
    }

    @Override
    public Response login(String email, String password) {
        try {
            Authentication authentication = this.authenticationManager(email, password);
            return new Response(
                    "login exitoso",
                    HttpStatus.OK.value(),
                    true,
                    authentication);
        } catch (Exception e) {
            return new Response(
                    "login no exitoso",
                    HttpStatus.UNAUTHORIZED.value(),
                    true,
                    null);
        }

    }

    public Authentication authenticationManager(String email, String password) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));
    }

}
