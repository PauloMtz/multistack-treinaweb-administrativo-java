package com.application.ediaristas.core.publishers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.application.ediaristas.core.events.NovoUsuarioEvent;
import com.application.ediaristas.core.models.Usuario;

@Component
public class NovoUsuarioPublisher {
    
    // a classe ApplicationEventPublisher é quem faz a publicação de eventos na aplicação
    @Autowired
    private ApplicationEventPublisher publisher;

    public void publicarEvento(Usuario usuario) {
        var evento = new NovoUsuarioEvent(this, usuario);
        publisher.publishEvent(evento);
    }
}
