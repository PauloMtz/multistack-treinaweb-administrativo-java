package com.application.ediaristas.core.listeners;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.application.ediaristas.core.events.NovoUsuarioEvent;
import com.application.ediaristas.core.models.Usuario;
import com.application.ediaristas.core.services.email.adapters.EmailServiceAdapter;
import com.application.ediaristas.core.services.email.dtos.EmailServiceParamsDto;

@Component
public class NovoUsuarioListener {
    
    @Autowired
    private EmailServiceAdapter emailServiceAdapter;

    @EventListener
    public void handleNovoUsuarioEvent(NovoUsuarioEvent event) {

        var usuario = event.getUsuario();
        
        if (usuario.isCliente() || usuario.isDiarista()) {
            var emailParams = criarEmailParams(usuario);

            emailServiceAdapter.enviarEmailComTemplateHtml(emailParams);
        }
    }

    private EmailServiceParamsDto criarEmailParams(Usuario usuario) {
        var props = criarEmailProps(usuario);
        var emailParams = new EmailServiceParamsDto();
        emailParams.setDestinatario(usuario.getEmail());
        emailParams.setAssunto("Cadastro realizado com sucesso");
        emailParams.setTemplate("emails/boas-vindas");
        emailParams.setProps(props);
        return emailParams;
    }

    private HashMap<String, Object> criarEmailProps(Usuario usuario) {
        var props = new HashMap<String, Object>();
        props.put("nomeUsuario", usuario.getNomeCompleto());
        props.put("tipoUsuario", usuario.getTipoUsuario().toString()); // toString ou name
        return props;
    }
}
