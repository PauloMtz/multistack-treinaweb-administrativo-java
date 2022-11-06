package com.application.ediaristas.api.assemblers;

// utiliza a chamada no método WebMvcLinkBuilder.linkTo, 
// depois clica em convert to static import para encurtar lá na chamada
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.stereotype.Component;

import com.application.ediaristas.api.controllers.DiariaRestController;
import com.application.ediaristas.api.dtos.responses.UsuarioResponseDto;
//import com.application.ediaristas.core.enums.TipoUsuario;

@Component
public class UsuarioAssembler implements AssemblerHateoas<UsuarioResponseDto> {

    @Override
    public void adicionaLink(UsuarioResponseDto resource) {
        // em vez de validar aqui, valida lá na classe UsuarioResponseDto
        /*var tipoUsuario = resource.getTipoUsuario();
        var isCliente = tipoUsuario.equals(TipoUsuario.CLIENTE.getId());*/

        if (resource.isCliente()) {
            var cadastrarDiariaLink = linkTo(methodOn(DiariaRestController.class)
                .cadastrarDiaria(null))
                .withRel("cadastrar_diaria")
                .withType("POST");

            resource.adicionarLinks(cadastrarDiariaLink);
        }
    }

    @Override
    public void adicionaLinks(List<UsuarioResponseDto> collectionResorces) {}
    
}
