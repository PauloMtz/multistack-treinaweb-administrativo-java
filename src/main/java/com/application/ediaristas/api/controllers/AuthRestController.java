package com.application.ediaristas.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.ediaristas.api.dtos.requests.TokenRequestDto;
import com.application.ediaristas.api.dtos.responses.TokenResponseDto;
import com.application.ediaristas.api.services.ApiAuthService;

@RestController
@RequestMapping("/auth")
public class AuthRestController {
    
    @Autowired
    private ApiAuthService service;

    @PostMapping("/token")
    public TokenResponseDto autenticar(@RequestBody @Valid TokenRequestDto request) {

        return service.autenticar(request);
    }
}
