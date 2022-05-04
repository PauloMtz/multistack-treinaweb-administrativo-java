package com.application.ediaristas.api.services;

import com.application.ediaristas.api.dtos.responses.DiaristaLocalidadesPagedResponseDto;
import com.application.ediaristas.api.dtos.responses.DisponibilidadeResponseDto;
import com.application.ediaristas.api.mappers.ApiDiaristaMapper;
import com.application.ediaristas.core.models.Usuario;
import com.application.ediaristas.core.repositories.UsuarioRepository;
import com.application.ediaristas.core.services.consultaendereco.adapters.EnderecoServiceAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;  

@Service
public class ApiDiaristaService {
    
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ApiDiaristaMapper mapper;

    @Autowired
    private EnderecoServiceAdapter adapter;

    public DiaristaLocalidadesPagedResponseDto buscarDiaristasPorCep(String cep) {
        
        var codigoIbge = buscarCodigoIbgePorCep(cep);

        var usuarioSort = Sort.sort(Usuario.class);
        var sort = usuarioSort.by(Usuario::getReputacao).descending();

        var numeroPagina = 0;
        var tamanhoPagina = 2;

        var pageable = PageRequest.of(numeroPagina, tamanhoPagina, sort);

        var resultado = repository.findByCidadesAtendidasCodigoIbge(codigoIbge, pageable);

        var diaristas = resultado.getContent()
            .stream()
            .map(mapper::toDiaristaLocalidadeResponse)
            .toList();

        return new DiaristaLocalidadesPagedResponseDto(diaristas, tamanhoPagina, resultado.getTotalElements());
    }

    /*
        SELECT u.id, u.nome_completo, u.email, ca.cidade, ca.estado, ca.codigo_ibge FROM usuario u 
	        INNER JOIN cidades_usuarios cu ON u.id = cu.usuario_id 
	        INNER JOIN cidade_atendida ca ON ca.id = cu.cidade_id;

        +----+----------------+----------------------+--------------+--------+-------------+
        | id | nome_completo  | email                | cidade       | estado | codigo_ibge |
        +----+----------------+----------------------+--------------+--------+-------------+
        |  1 | User Admin     | admin@admin          | São Paulo    | SP     | 3550308     |
        |  5 | Fernanda Teste | fernanda@email.teste | São Paulo    | SP     | 3550308     |
        |  3 | Maria Teste    | maria@email.teste    | São Paulo    | SP     | 3550308     |
        |  4 | Ribamar Teste  | ribamar@email.teste  | Campinas     | SP     | 3509502     |
        |  3 | Maria Teste    | maria@email.teste    | Santo André  | SP     | 3547809     |
        +----+----------------+----------------------+--------------+--------+-------------+
    */

    public DisponibilidadeResponseDto verificaDisponibilidadePorCep(String cep) {
        var codigoIbge = buscarCodigoIbgePorCep(cep);
        var disponibilidade = repository.existsByCidadesAtendidasCodigoIbge(codigoIbge);
        return new DisponibilidadeResponseDto(disponibilidade);
    }

    // é boa prática deixar os métodos privados por último
    private String buscarCodigoIbgePorCep(String cep) {
        return adapter.buscarEnderecoPorCep(cep).getIbge();
    }
}
