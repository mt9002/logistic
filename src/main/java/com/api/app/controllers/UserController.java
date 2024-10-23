package com.api.app.controllers;

import com.api.domain.interfaces.incoming.IUserService;
import com.api.app.dto.Response;
import com.api.domain.models.auth.Client;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService iUserService;

    @Autowired
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @Operation(security = @SecurityRequirement(name = "bearer-key"))
    @GetMapping("/findById")
    public Response<Client> getById(@RequestParam(value = "id") Long id) {
        var response = iUserService.getById(id);
        return response;
    }
}
