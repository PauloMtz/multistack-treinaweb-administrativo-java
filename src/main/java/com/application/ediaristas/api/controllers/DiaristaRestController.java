package com.application.ediaristas.api.controllers;

import java.util.List;

import com.application.ediaristas.api.dtos.responses.DiaristaLocalidadeResponse;
import com.application.ediaristas.api.services.ApiDiaristaService;
import com.application.ediaristas.core.services.consultaendereco.adapters.EnderecoServiceAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diaristas")
public class DiaristaRestController {
    
    @Autowired
    private ApiDiaristaService service;

    @Autowired
    private EnderecoServiceAdapter adapter;

    @GetMapping("/localidades")
    public List<DiaristaLocalidadeResponse> buscarDiaristasPorCep() {
        var endereco = adapter.buscarEnderecoPorCep("72002-052");
        System.out.println(endereco);
        return service.buscarDiaristasPorCep();
    }
}
