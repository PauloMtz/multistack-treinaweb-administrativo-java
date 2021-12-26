package com.application.ediaristas.auth.service;

import com.application.ediaristas.auth.models.UsuarioAutenticado;
import com.application.ediaristas.core.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) 
        throws UsernameNotFoundException {

        var mensagem = String.format("Usuário com o e-mail %s não encontrado", email);

        return repository.findByEmail(email)
            .map(UsuarioAutenticado::new)
            .orElseThrow(() -> new UsernameNotFoundException(mensagem));
    }
    
}
