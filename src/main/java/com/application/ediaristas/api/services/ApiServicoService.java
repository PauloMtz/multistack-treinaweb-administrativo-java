package com.application.ediaristas.api.services;

import java.util.List;

import com.application.ediaristas.api.dtos.responses.ServicoResponseDto;
import com.application.ediaristas.api.mappers.ApiServicoMapper;
import com.application.ediaristas.core.models.Servico;
import com.application.ediaristas.core.repositories.ServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ApiServicoService {
    
    @Autowired
    private ServicoRepository repository;

    @Autowired
    private ApiServicoMapper mapper;

    public List<ServicoResponseDto> buscarTodos() {

        var servicoSort = Sort.sort(Servico.class);
        var ordenacao = servicoSort.by(Servico::getPosicao).ascending();

        return repository.findAll(ordenacao)
                .stream()
                .map(mapper::convertToResponse)
                .toList();

        /*return repository.findAll()
                .stream()
                .map(servico -> mapper.convertToResponse(servico))
                .toList();

        // isso abaixo, representa o código acima
        var servicos = repository.findAll();
        var response = new ArrayList<ServicoResponseDto>();

        for (Servico servico : servicos) {
            var servicoResponse = mapper.convertToResponse(servico);
            response.add(servicoResponse);
        }

        return response;*/
    }
}
