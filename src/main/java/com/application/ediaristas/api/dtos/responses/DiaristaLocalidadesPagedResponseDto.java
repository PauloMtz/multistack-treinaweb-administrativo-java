package com.application.ediaristas.api.dtos.responses;

import java.util.List;

//import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
public class DiaristaLocalidadesPagedResponseDto {
    
    private List<DiaristaLocalidadeResponseDto> diaristas;

    //@JsonProperty("quantidade_excedente")
    private Long quantidadeDiaristasExcedentes;

    public DiaristaLocalidadesPagedResponseDto(
            List<DiaristaLocalidadeResponseDto> diaristas,
            Integer tamanhoPagina, Long totalElementos) {
        this.diaristas = diaristas;
        this.quantidadeDiaristasExcedentes = totalElementos > tamanhoPagina ? totalElementos - tamanhoPagina : 0;
    }

    public List<DiaristaLocalidadeResponseDto> getDiaristas() {
        return diaristas;
    }

    public void setDiaristas(List<DiaristaLocalidadeResponseDto> diaristas) {
        this.diaristas = diaristas;
    }

    public Long getQuantidadeDiaristasExcedentes() {
        return quantidadeDiaristasExcedentes;
    }

    public void setQuantidadeDiaristasExcedentes(Long quantidadeDiaristasExcedentes) {
        this.quantidadeDiaristasExcedentes = quantidadeDiaristasExcedentes;
    }

    @Override
    public String toString() {
        return "DiaristaLocalidadesPagedResponse [diaristas=" + diaristas + ", quantidadeDiaristasExcedentes="
                + quantidadeDiaristasExcedentes + "]";
    }
}
