package com.application.ediaristas.api.dtos.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
public class PagamentoRequestDto {
    
    @NotNull
    @NotEmpty
    private String cardHash;

    public PagamentoRequestDto() {
    }

    public PagamentoRequestDto(String cardHash) {
        this.cardHash = cardHash;
    }

    public String getCardHash() {
        return cardHash;
    }

    public void setCardHash(String cardHash) {
        this.cardHash = cardHash;
    }
}
