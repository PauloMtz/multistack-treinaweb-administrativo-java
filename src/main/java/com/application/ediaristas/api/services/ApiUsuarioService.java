package com.application.ediaristas.api.services;

import com.application.ediaristas.api.dtos.requests.UsuarioRequestDto;
import com.application.ediaristas.api.dtos.responses.UsuarioResponseDto;
import com.application.ediaristas.api.mappers.ApiUsuarioMapper;
import com.application.ediaristas.core.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApiUsuarioService {
    
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ApiUsuarioMapper mapper;

    @Autowired
    private PasswordEncoder encoder;

    public UsuarioResponseDto cadastrar(UsuarioRequestDto request) {
        var usuarioParaCadastro = mapper.usuarioToModel(request);
        var encoderSenha = encoder.encode(usuarioParaCadastro.getSenha());
        usuarioParaCadastro.setSenha(encoderSenha);
        var usuarioCadastrar = repository.save(usuarioParaCadastro);
        return mapper.usuarioToResponseDto(usuarioCadastrar);
    }
}
