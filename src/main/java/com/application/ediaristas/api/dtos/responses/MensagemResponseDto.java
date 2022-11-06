package com.application.ediaristas.api.dtos.responses;

public class MensagemResponseDto {
    
    private String mensagem;

    public MensagemResponseDto() {
    }

    public MensagemResponseDto(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
