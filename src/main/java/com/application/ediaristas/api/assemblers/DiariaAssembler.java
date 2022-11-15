package com.application.ediaristas.api.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.ediaristas.api.controllers.DiariaPagamentoRestController;
import com.application.ediaristas.api.dtos.responses.DiariaResponseDto;
import com.application.ediaristas.core.utils.SecurityUtils;

@Component
public class DiariaAssembler implements AssemblerHateoas<DiariaResponseDto> {

    @Autowired
    private SecurityUtils utils;

    @Override
    public void adicionaLink(DiariaResponseDto resource) {
        var id = resource.getId();

        if (utils.isClienteAuthenticated() && resource.isDiariaSemPagamento()) {
            var pagarDiariaLink = linkTo(methodOn(DiariaPagamentoRestController.class)
                .pagamento(null, id)).withRel("pagar_diaria").withType("POST");
            
            resource.adicionarLinks(pagarDiariaLink);
        }
    }

    @Override
    public void adicionaLinks(List<DiariaResponseDto> collectionResorces) {}
    
}
