package com.application.ediaristas.api.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.application.ediaristas.api.dtos.responses.DiaristaLocalidadeResponse;
import com.application.ediaristas.api.mappers.ApiDiaristaMapper;
import com.application.ediaristas.core.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  

@Service
public class ApiDiaristaService<A> {
    
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ApiDiaristaMapper mapper;

    public List<DiaristaLocalidadeResponse> buscarDiaristasPorCep() {
        
        return repository.findAll()
            .stream()
            .map(mapper::toDiaristaLocalidadeResponse)
            .toList();
    }
}
