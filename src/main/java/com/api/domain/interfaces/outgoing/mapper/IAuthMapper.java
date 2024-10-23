package com.api.domain.interfaces.outgoing.mapper;

import com.api.app.dto.auth.RegisterDTO;
import com.api.domain.models.auth.Client;

public interface IAuthMapper {
    Client DtoToEntity(RegisterDTO registerRequestDTO);
}
