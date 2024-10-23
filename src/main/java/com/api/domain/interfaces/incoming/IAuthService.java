package com.api.domain.interfaces.incoming;

import com.api.app.dto.auth.LoginRequestDTO;
import com.api.app.dto.auth.RegisterDTO;
import com.api.app.dto.Response;

public interface IAuthService {
    Response Register(RegisterDTO registerRequestDTO);
    Response<String> Login(LoginRequestDTO LoginRequestDTO);
}
