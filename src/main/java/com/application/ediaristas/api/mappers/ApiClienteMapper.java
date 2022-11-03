package com.application.ediaristas.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.application.ediaristas.api.dtos.responses.ClienteResponseDto;
import com.application.ediaristas.core.models.Usuario;

@Mapper(componentModel = "spring")
public interface ApiClienteMapper {
    
    ApiClienteMapper INSTANCE = Mappers.getMapper(ApiClienteMapper.class);

    @Mapping(target = "tipoUsuario", source = "tipoUsuario.id")
    @Mapping(target = "fotoUsuario", source = "fotoUsuario.url")
    ClienteResponseDto toResponse(Usuario model);
}
