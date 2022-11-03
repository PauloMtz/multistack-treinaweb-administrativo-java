package com.application.ediaristas.api.mappers;

import com.application.ediaristas.api.dtos.requests.DiariaRequestDto;
import com.application.ediaristas.api.dtos.responses.DiariaResponseDto;
import com.application.ediaristas.core.models.Diaria;
import com.application.ediaristas.core.models.Servico;
import com.application.ediaristas.core.repositories.ServicoRepository;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = ApiClienteMapper.class)
public abstract class ApiDiariaMapper {
    
    @Autowired
    protected ServicoRepository servicoRepository;

    public static final ApiDiariaMapper INSTANCE = Mappers.getMapper(ApiDiariaMapper.class);

    public abstract Diaria toModel(DiariaRequestDto request);

    @Mapping(target = "status", source = "status.id")
    @Mapping(target = "nomeServico", source = "servico.nome")
    @Mapping(target = "servico", source = "servico.id")
    public abstract DiariaResponseDto toResponse(Diaria model);

    protected Servico longToServico(Long servicoId) {
        return servicoRepository.findById(servicoId)
            .orElseThrow(IllegalArgumentException::new);
    }
}
