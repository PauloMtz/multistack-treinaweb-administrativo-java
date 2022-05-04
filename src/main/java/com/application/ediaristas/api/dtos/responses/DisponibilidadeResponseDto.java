package com.application.ediaristas.api.dtos.responses;

public class DisponibilidadeResponseDto {
    
    private Boolean disponibilidade;

    public DisponibilidadeResponseDto(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public DisponibilidadeResponseDto() {
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
