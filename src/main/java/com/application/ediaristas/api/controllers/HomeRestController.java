package com.application.ediaristas.api.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.application.ediaristas.api.dtos.responses.HateoasResponseDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeRestController {

    // http://localhost:8080/api
    
    @GetMapping
    public HateoasResponseDto home() {

        var listarServicosLink = linkTo(
            methodOn(ServicoRestController.class)
                .buscarTodos())
                .withRel("listar_servicos")
                .withType("GET");

        var enderecoCepLink = linkTo(
            methodOn(EnderecoRestController.class)
                .buscarEnderecoPorCep(null))
                .withRel("endereco_cep")
                .expand()
                .withType("GET");

        var diaristasLocalidadesLink = linkTo(
            methodOn(DiaristaRestController.class)
                .buscarDiaristasPorCep(null))
                .withRel("diaristas_localidades")
                .expand()
                .withType("GET");

        var verificaDisponibilidadeAtendeLink = linkTo(
            methodOn(DiaristaRestController.class)
                .verificarDisponibilidadePorCep(null))
                .withRel("verificar_disponibilidade_atendimento")
                .expand()
                .withType("GET");

        var cadastrarUsuarioLink = linkTo(
            methodOn(UsuarioRestController.class)
                .cadastrar(null))
                .withRel("cadastrar_usuario")
                .withType("POST");

        var loginLink = linkTo(
            methodOn(AuthRestController.class)
                .autenticar(null))
                .withRel("login")
                .withType("POST");

        var usuarioLogadoLink = linkTo(
            methodOn(MeRestController.class)
                .me())
                .withRel("usuario_logado")
                .withType("GET");

        var refreshLink = linkTo(
            methodOn(AuthRestController.class)
                .reAutenticar(null))
                .withRel("refresh")
                .withType("POST");

        var logoutLink = linkTo(
            methodOn(AuthRestController.class)
                .logout(null))
                .withRel("logout")
                .withType("POST");

        var response = new HateoasResponseDto();

        response.adicionarLinks(
            listarServicosLink,
            enderecoCepLink,
            diaristasLocalidadesLink,
            verificaDisponibilidadeAtendeLink,
            cadastrarUsuarioLink,
            loginLink,
            usuarioLogadoLink,
            refreshLink,
            logoutLink
        );

        return response;
    }
}
