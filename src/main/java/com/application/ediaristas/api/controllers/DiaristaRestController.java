package com.application.ediaristas.api.controllers;

import com.application.ediaristas.api.dtos.responses.DiaristaLocalidadesPagedResponse;
import com.application.ediaristas.api.services.ApiDiaristaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diaristas")
public class DiaristaRestController {
    
    @Autowired
    private ApiDiaristaService service;

    @GetMapping("/localidades")
    public DiaristaLocalidadesPagedResponse buscarDiaristasPorCep(@RequestParam String cep) {

        return service.buscarDiaristasPorCep(cep);
    }
}
