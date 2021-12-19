package com.application.ediaristas.web.mappers;

import com.application.ediaristas.core.models.Usuario;
import com.application.ediaristas.web.dtos.UsuarioCadastroForm;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WebUsuarioMapper {

    WebUsuarioMapper INSTANCE = Mappers.getMapper(WebUsuarioMapper.class);

    Usuario toModel(UsuarioCadastroForm form);

}
