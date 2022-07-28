package com.application.ediaristas.api.dtos.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
public class UsuarioCadastroResponseDto extends UsuarioResponseDto {

    private TokenResponseDto token;

    public UsuarioCadastroResponseDto() {
    }

    public UsuarioCadastroResponseDto(TokenResponseDto token) {
        this.token = token;
    }

    public TokenResponseDto getToken() {
        return token;
    }

    public void setToken(TokenResponseDto token) {
        this.token = token;
    }
}