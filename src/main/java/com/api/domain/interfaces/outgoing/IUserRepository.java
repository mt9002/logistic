package com.api.domain.interfaces.outgoing;

import com.api.app.dto.Response;
import com.api.domain.models.auth.Client;

public interface IUserRepository {
    Response<Client> getById(Long id);
}
