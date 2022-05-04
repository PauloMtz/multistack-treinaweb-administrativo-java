package com.application.ediaristas.api.mappers;

import com.application.ediaristas.api.dtos.responses.ServicoResponseDto;
import com.application.ediaristas.core.models.Servico;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApiServicoMapper {

    ApiServicoMapper INSTANCE = Mappers.getMapper(ApiServicoMapper.class);

    @Mapping(target = "icone", source = "icone.nome")
    ServicoResponseDto convertToResponse(Servico model);
}
