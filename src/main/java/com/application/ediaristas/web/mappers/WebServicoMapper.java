package com.application.ediaristas.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.application.ediaristas.core.models.Servico;
import com.application.ediaristas.web.dtos.ServicoForm;

@Mapper(componentModel = "spring")
public interface WebServicoMapper {

    WebServicoMapper INSTANCE = Mappers.getMapper(WebServicoMapper.class);

    Servico toModel(ServicoForm form);

    ServicoForm toForm(Servico model);
    
}
