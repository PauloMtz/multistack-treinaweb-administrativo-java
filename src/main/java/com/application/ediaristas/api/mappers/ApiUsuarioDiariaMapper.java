package com.application.ediaristas.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.application.ediaristas.api.dtos.responses.UsuarioDiariaResponseDto;
import com.application.ediaristas.core.models.Usuario;

@Mapper(componentModel = "spring")
public interface ApiUsuarioDiariaMapper {

    ApiUsuarioDiariaMapper INSTANCE = Mappers.getMapper(ApiUsuarioDiariaMapper.class);

    @Mapping(target = "tipoUsuario", source = "tipoUsuario.id")
    @Mapping(target = "fotoUsuario", source = "fotoUsuario.url")
    UsuarioDiariaResponseDto toResponse(Usuario model);

}
