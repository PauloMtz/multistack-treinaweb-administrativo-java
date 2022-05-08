package com.application.ediaristas.api.mappers;

import java.util.stream.Stream;

import com.application.ediaristas.api.dtos.requests.UsuarioRequestDto;
import com.application.ediaristas.core.models.TipoUsuario;
import com.application.ediaristas.core.models.Usuario;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApiUsuarioMapper {
    
    ApiUsuarioMapper INSTANCE = Mappers.getMapper(ApiUsuarioMapper.class);

    // o campo 'senha' lá de /core/models/Usuario recebe 'password' de UsuarioRequestDto
    @Mapping(target = "senha", source = "password")
    Usuario usuarioToModel(UsuarioRequestDto request);

    default TipoUsuario integerToTipoUsuario(Integer valor) {
        /*if (valor == 1) {
            return TipoUsuario.CLIENTE;
        } else if (valor == 2) {
            return TipoUsuario.DIARISTA;
        } else if (valor == 3) {
            return TipoUsuario.ADMIN;
        } else {
            throw new IllegalArgumentException("Tipo de usuário inválido");
        }*/

        return Stream
            .of(TipoUsuario.values())
            .filter(tipo -> tipo.getId().equals(valor)).findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Tipo de usuário inválido"));
    }
}
