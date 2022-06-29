package com.application.ediaristas.api.dtos.responses;

public class TokenResponseDto {
    
    private String acesso;

    public TokenResponseDto() {
    }

    public TokenResponseDto(String acesso) {
        this.acesso = acesso;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }
}
