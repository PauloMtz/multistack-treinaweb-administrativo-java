package com.application.ediaristas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.ediaristas.api.assemblers.UsuarioAssembler;
import com.application.ediaristas.api.dtos.responses.UsuarioResponseDto;
import com.application.ediaristas.api.services.ApiMeService;
import com.application.ediaristas.core.permissions.EdiaristasPermissions;

@RestController
@RequestMapping("/api/me")
public class MeRestController {

    @Autowired
    private ApiMeService service;

    @Autowired
    private UsuarioAssembler assembler;
    
    /**
     * a anotação @PreAuthorize é habilitada lá no SecurityConfig
     * através da anotação @EnableGlobalMethodSecurity
     * que permite que o usuário acesse a rota /api/me
     * se estiver autenticado
     */
    
    //@PreAuthorize("isAuthenticated")
    //@PreAuthorize("hasAnyAuthority('DIARISTA', 'CLIENTE')")
    @EdiaristasPermissions.isDiaristaOrCliente
    @GetMapping
    public UsuarioResponseDto me() {
        var response = service.obterUsuarioLogado();
        assembler.adicionaLink(response);

        return response;
    }
}
