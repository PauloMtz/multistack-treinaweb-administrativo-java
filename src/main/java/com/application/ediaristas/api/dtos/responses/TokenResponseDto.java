package com.application.ediaristas.api.dtos.responses;

public class TokenResponseDto {
    
    private String acesso;
    private String refresh;

    public TokenResponseDto() {
    }

    public TokenResponseDto(String acesso, String refresh) {
        this.acesso = acesso;
        this.refresh = refresh;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public String getRefresh() {
        return refresh;
    }

    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }
}
