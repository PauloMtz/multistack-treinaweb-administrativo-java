package com.application.ediaristas.core.services.consultaendereco.providers;

import com.application.ediaristas.core.services.consultaendereco.adapters.EnderecoServiceAdapter;
import com.application.ediaristas.core.services.consultaendereco.dtos.EnderecoResponseDto;
import com.application.ediaristas.core.services.consultaendereco.exceptions.EnderecoServiceException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ViaCepProvider implements EnderecoServiceAdapter {

    private static final String URL_TEMPLATE = "https://viacep.com.br/ws/{cep}/json/";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public EnderecoResponseDto buscarEnderecoPorCep(String cep) throws EnderecoServiceException {
        
        var url = UriComponentsBuilder
            .fromUriString(URL_TEMPLATE)
            .buildAndExpand(cep)
            .toString();

        ResponseEntity<EnderecoResponseDto> response;

        try {
            response = restTemplate.getForEntity(url, EnderecoResponseDto.class);
        } catch (HttpClientErrorException.BadRequest e) {
            throw new EnderecoServiceException("O CEP informado é inválido.");
        }

        if (response.getBody().getCep() == null) {
            throw new EnderecoServiceException("CEP não encontrado.");
        }
        
        return response.getBody();
    }
    
}
