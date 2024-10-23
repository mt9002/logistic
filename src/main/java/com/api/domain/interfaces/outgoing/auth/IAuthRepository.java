package com.api.domain.interfaces.outgoing.auth;

import com.api.app.dto.Response;
import com.api.app.dto.auth.RegisterDTO;
import com.api.domain.models.auth.Client;

public interface IAuthRepository{
    Response register(RegisterDTO registerRequestDTO);
    Response login(String email, String password);
    Response<Client> getByUserEmail(String email);
}
