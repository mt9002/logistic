package com.api.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/register") 
    public String register() {
        return "register";
    }

    @GetMapping("/login")
    public String login() { 
        return "login";
    }
}
