package com.application.ediaristas.core.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.application.ediaristas.core.exceptions.DiariaNaoEncontradaException;
import com.application.ediaristas.core.exceptions.UsuarioNaoEncontradoException;
import com.application.ediaristas.core.models.Diaria;
import com.application.ediaristas.core.models.Usuario;
import com.application.ediaristas.core.repositories.DiariaRepository;
import com.application.ediaristas.core.repositories.UsuarioRepository;

@Component
public class SecurityUtils {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DiariaRepository diariaRepository;
    
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String getEmailUsuarioLogado() {
        return getAuthentication().getName();
    }

    public Usuario getUsuarioLogado() {
        
        var email = getEmailUsuarioLogado();
        var mensagem = String.format("Usuário com e-mail %s não encontrado.", email);

        return usuarioRepository.findByEmail(email)
            .orElseThrow(() -> new UsuarioNaoEncontradoException(mensagem));
    }

    public Boolean isClienteDaDiaria(Long id) {
        var diaria = buscarDiariaPorId(id);
        var usuarioLogado = getUsuarioLogado();

        if(!usuarioLogado.isCliente()) {
            return false;
        }

        return diaria.getCliente().equals(usuarioLogado);
    }

    private Diaria buscarDiariaPorId(Long id) {
        var mensagem = String.format("Diária com ID %d não encontrada", id);
        return diariaRepository.findById(id)
            .orElseThrow(() -> new DiariaNaoEncontradaException(mensagem));
    }
}
