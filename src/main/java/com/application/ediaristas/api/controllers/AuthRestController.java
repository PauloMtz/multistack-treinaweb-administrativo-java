package com.application.ediaristas.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.application.ediaristas.api.dtos.requests.RefreshRequestDto;
import com.application.ediaristas.api.dtos.requests.TokenRequestDto;
import com.application.ediaristas.api.dtos.responses.TokenResponseDto;
import com.application.ediaristas.api.services.ApiAuthService;

@RestController
@RequestMapping("/auth")
public class AuthRestController {
    
    @Autowired
    private ApiAuthService service;

    @PostMapping("/token")
    public TokenResponseDto autenticar(@RequestBody @Valid TokenRequestDto tokenRequest) {

        return service.autenticar(tokenRequest);
    }

    @PostMapping("/refresh")
    public TokenResponseDto reAutenticar(@RequestBody @Valid RefreshRequestDto refreshRequest) {
        return service.reAutenticar(refreshRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody @Valid RefreshRequestDto request) {
        service.logout(request);
        return new ResponseEntity<>(HttpStatus.RESET_CONTENT);
    }

    // poderia utilizar esse método abaixo, mas não funcionaria com HateOas
    // porque o HateOas precisa que retorne alguma coisa
    @ResponseStatus(code = HttpStatus.RESET_CONTENT)
    public void logout_2(@RequestBody @Valid RefreshRequestDto request) {
        service.logout(request);
    }
}
