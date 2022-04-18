package com.application.ediaristas.api.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.application.ediaristas.api.dtos.responses.DiaristaLocalidadeResponse;
import com.application.ediaristas.api.dtos.responses.DiaristaLocalidadesPagedResponse;
import com.application.ediaristas.api.mappers.ApiDiaristaMapper;
import com.application.ediaristas.core.models.Usuario;
import com.application.ediaristas.core.repositories.UsuarioRepository;
import com.application.ediaristas.core.services.consultaendereco.adapters.EnderecoServiceAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;  

@Service
public class ApiDiaristaService<A> {
    
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ApiDiaristaMapper mapper;

    @Autowired
    private EnderecoServiceAdapter adapter;

    public DiaristaLocalidadesPagedResponse buscarDiaristasPorCep(String cep) {
        
        var codigoIbge = adapter.buscarEnderecoPorCep(cep).getIbge();

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

        return new DiaristaLocalidadesPagedResponse(diaristas, tamanhoPagina, resultado.getTotalElements());
    }
}
