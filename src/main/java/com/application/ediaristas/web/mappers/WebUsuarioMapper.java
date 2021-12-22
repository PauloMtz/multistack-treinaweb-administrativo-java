package com.application.ediaristas.web.mappers;

import com.application.ediaristas.core.models.Usuario;
import com.application.ediaristas.web.dtos.UsuarioCadastroForm;
import com.application.ediaristas.web.dtos.UsuarioEdicaoForm;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WebUsuarioMapper {

    WebUsuarioMapper INSTANCE = Mappers.getMapper(WebUsuarioMapper.class);

    Usuario toModel(UsuarioCadastroForm form);

    /*
        após criar o recursoForm no package 'dtos'
        e implementar essa classe de mapper
        deve-se dar os comandos a seguir:
        - mvn clean
        - mvn package
        limpa e gera novos mappers em:
        /target/generated-sources/.../mappers/...
    */

    Usuario toModel(UsuarioEdicaoForm form);

    UsuarioEdicaoForm toForm(Usuario model);
}
