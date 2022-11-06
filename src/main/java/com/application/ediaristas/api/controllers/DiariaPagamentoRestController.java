package com.application.ediaristas.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.ediaristas.api.dtos.requests.PagamentoRequestDto;
import com.application.ediaristas.api.dtos.responses.MensagemResponseDto;
import com.application.ediaristas.api.services.ApiDiariaPagamentoService;

@RestController
@RequestMapping("/api/diarias/{id}")
public class DiariaPagamentoRestController {
    
    @Autowired
    private ApiDiariaPagamentoService service;

    @PostMapping("/pagamento")
    public MensagemResponseDto pagamento(
        @RequestBody @Valid PagamentoRequestDto request,
        @PathVariable Long id) {
        
        return service.pagamento(request, id);
    }
}
