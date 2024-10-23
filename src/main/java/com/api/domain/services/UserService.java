package com.api.domain.services;

import com.api.app.dto.Response;
import com.api.domain.interfaces.incoming.IUserService;
import com.api.domain.interfaces.outgoing.IUserRepository;
import com.api.domain.models.auth.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    private final IUserRepository iUserRepository;

    @Autowired
    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }
    
    @Override
    public Response<Client> getById(Long id) {
        var resnponse  = iUserRepository.getById(id);
        return resnponse;
    }
}
