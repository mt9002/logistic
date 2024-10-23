package com.api.app.controllers.auth;

import com.api.app.dto.Response;
import com.api.app.dto.auth.LoginRequestDTO;
import com.api.app.dto.auth.RegisterDTO;
import com.api.domain.interfaces.incoming.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private final IAuthService iAuthService;

    @Autowired
    public AuthController(IAuthService iAuthService) {
        this.iAuthService = iAuthService;
    } 
    
    @PostMapping("/login")
    public Response<String> login(@RequestBody LoginRequestDTO loginRequestDTO){
        System.out.println(loginRequestDTO.getPassword());
        var response = iAuthService.Login(loginRequestDTO);
        return response;
    }
   
    @PostMapping("/register")
    public Response register(@RequestBody RegisterDTO registerRequestDTO){
        var response = iAuthService.Register(registerRequestDTO);
        return response;
    }
}
