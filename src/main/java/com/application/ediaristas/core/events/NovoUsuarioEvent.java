package com.application.ediaristas.core.events;

import org.springframework.context.ApplicationEvent;

import com.application.ediaristas.core.models.Usuario;

public class NovoUsuarioEvent extends ApplicationEvent {

    // essa classe lança um evento quando um usuário for cadastrado
    // quando cadastrar um usuário, uma classe listener ficará escutando
    // para depois de efetuado o cadastro, disparar um e-mail para o usuário
    
    private Usuario usuario;

    public NovoUsuarioEvent(Object source, Usuario usuario) {
        super(source);
        this.usuario = usuario;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
}
