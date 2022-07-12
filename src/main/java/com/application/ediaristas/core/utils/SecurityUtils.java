package com.application.ediaristas.core.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.application.ediaristas.core.exceptions.UsuarioNaoEncontradoException;
import com.application.ediaristas.core.models.Usuario;
import com.application.ediaristas.core.repositories.UsuarioRepository;

@Component
public class SecurityUtils {

    @Autowired
    private UsuarioRepository repository;
    
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String getEmailUsuarioLogado() {
        return getAuthentication().getName();
    }

    public Usuario getUsuarioLogado() {
        
        var email = getEmailUsuarioLogado();
        var mensagem = String.format("Usuário com e-mail %s não encontrado.", email);

        return repository.findByEmail(email)
            .orElseThrow(() -> new UsuarioNaoEncontradoException(mensagem));
    }
}
