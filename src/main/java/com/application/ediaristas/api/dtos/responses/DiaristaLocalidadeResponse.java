package com.application.ediaristas.api.dtos.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
public class DiaristaLocalidadeResponse {
    
    private String nomeCompleto;
    private Double reputacao;
    private String fotoUsuario;
    private String cidade;

    public DiaristaLocalidadeResponse() {
    }

    public DiaristaLocalidadeResponse(String nomeCompleto, Double reputacao, String fotoUsuario, String cidade) {
        this.nomeCompleto = nomeCompleto;
        this.reputacao = reputacao;
        this.fotoUsuario = fotoUsuario;
        this.cidade = cidade;
    }
    
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Double getReputacao() {
        return reputacao;
    }

    public void setReputacao(Double reputacao) {
        this.reputacao = reputacao;
    }

    public String getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(String fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "DiaristaLocalidadeResponse [cidade=" + cidade + ", fotoUsuario=" + fotoUsuario + ", nomeCompleto="
                + nomeCompleto + ", reputacao=" + reputacao + "]";
    }
}
