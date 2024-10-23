package com.api.domain.interfaces.incoming;

import com.api.app.dto.Response;
import com.api.domain.models.auth.Client;


public interface IUserService {
    Response<Client> getById(Long id);
}
