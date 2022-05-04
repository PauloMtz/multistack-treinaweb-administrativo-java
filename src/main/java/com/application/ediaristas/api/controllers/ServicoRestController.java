package com.application.ediaristas.api.controllers;

import java.util.List;

import com.application.ediaristas.api.dtos.responses.ServicoResponseDto;
import com.application.ediaristas.api.services.ApiServicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/servicos")
public class ServicoRestController {
    
    @Autowired
    private ApiServicoService service;

    @GetMapping
    public List<ServicoResponseDto> buscarTodos() {
        return service.buscarTodos();
    }
}
