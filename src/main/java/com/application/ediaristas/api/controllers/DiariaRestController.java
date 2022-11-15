package com.application.ediaristas.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.application.ediaristas.api.assemblers.DiariaAssembler;
import com.application.ediaristas.api.dtos.requests.DiariaRequestDto;
import com.application.ediaristas.api.dtos.responses.DiariaResponseDto;
import com.application.ediaristas.api.services.ApiDiariaService;
import com.application.ediaristas.core.permissions.EdiaristasPermissions;

@RestController
@RequestMapping("/api/diarias")
public class DiariaRestController {
    
    @Autowired
    private ApiDiariaService service;

    @Autowired
    private DiariaAssembler assembler;

    @EdiaristasPermissions.isCliente
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public DiariaResponseDto cadastrarDiaria(@RequestBody @Valid DiariaRequestDto request) {
        var response = service.cadastrar(request);
        assembler.adicionaLink(response);
        
        return response;
    }
}
