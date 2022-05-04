package com.application.ediaristas.api.controllers;

import com.application.ediaristas.core.services.consultaendereco.adapters.EnderecoServiceAdapter;
import com.application.ediaristas.core.services.consultaendereco.dtos.EnderecoResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoRestController {
    
    @Autowired
    private EnderecoServiceAdapter serviceAdapter;

    @GetMapping
    public EnderecoResponseDto buscarEnderecoPorCep(@RequestParam String cep) {

        return serviceAdapter.buscarEnderecoPorCep(cep);
    }
}
