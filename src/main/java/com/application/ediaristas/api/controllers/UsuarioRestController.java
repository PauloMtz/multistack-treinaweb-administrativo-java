package com.application.ediaristas.api.controllers;

import javax.validation.Valid;

import com.application.ediaristas.api.assemblers.UsuarioAssembler;
import com.application.ediaristas.api.dtos.requests.UsuarioRequestDto;
import com.application.ediaristas.api.dtos.responses.UsuarioResponseDto;
import com.application.ediaristas.api.services.ApiUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {
    
    @Autowired
    private ApiUsuarioService service;

    @Autowired
    private UsuarioAssembler assembler;

    @PostMapping("/usuarios")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UsuarioResponseDto cadastrar(@ModelAttribute @Valid UsuarioRequestDto request) {
        /*
            insert into usuario (chave_pix, cpf, email, foto_documento, 
                foto_usuario, nascimento, nome_completo, reputacao, 
                senha, telefone, tipo_usuario) 
                values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        */
        var response = service.cadastrar(request);
        assembler.adicionaLink(response);

        return response;
    }
}
