package com.application.ediaristas.api.mappers;

import com.application.ediaristas.api.dtos.responses.DiaristaLocalidadeResponseDto;
import com.application.ediaristas.core.models.Usuario;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApiDiaristaMapper {
    
    ApiDiaristaMapper INSTANCE = Mappers.getMapper(ApiDiaristaMapper.class);

    // método de conversão, que vai retornar diarista localidade
    // converte a String da classe dto para o tipo Foto
    @Mapping(target = "fotoUsuario", source = "fotoUsuario.url")
    DiaristaLocalidadeResponseDto toDiaristaLocalidadeResponse(Usuario model);
}
