package com.application.ediaristas.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.application.ediaristas.api.dtos.responses.UsuarioResponseDto;
import com.application.ediaristas.api.mappers.ApiUsuarioMapper;
import com.application.ediaristas.core.repositories.UsuarioRepository;

// obtém o usuário logado na aplicação

@Service
public class ApiMeService {
    
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ApiUsuarioMapper mapper;

    public UsuarioResponseDto obterUsuarioLogado() {
        // pega o email do usuário logado sem utilizar o Principal do Spring Boot
        var email = SecurityContextHolder.getContext().getAuthentication().getName();

        // pega os dados do usuário logado pelo emai
        var usuarioLogado = repository.findByEmail(email).get();

        return mapper.usuarioToResponseDto(usuarioLogado);
    }
}
