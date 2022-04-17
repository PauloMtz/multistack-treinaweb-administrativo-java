package com.application.ediaristas.core.services.consultaendereco.adapters;

import com.application.ediaristas.core.services.consultaendereco.dtos.EnderecoResponseDto;
import com.application.ediaristas.core.services.consultaendereco.exceptions.EnderecoServiceException;

public interface EnderecoServiceAdapter {
    
    EnderecoResponseDto buscarEnderecoPorCep(String cep) throws EnderecoServiceException;
}
