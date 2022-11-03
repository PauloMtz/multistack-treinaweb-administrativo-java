package com.application.ediaristas.api.dtos.responses;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
public class ClienteResponseDto {
    
    private Long id;
    private String nomeCompleto;
    private LocalDate nascimento;
    private String fotoUsuario;
    private String telefone;
    private Integer tipoUsuario;
    private Double reputacao;

    public ClienteResponseDto() {
    }

    public ClienteResponseDto(Long id, String nomeCompleto, LocalDate nascimento, 
        String fotoUsuario, String telefone, Integer tipoUsuario, 
        Double reputacao) {
            
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.nascimento = nascimento;
        this.fotoUsuario = fotoUsuario;
        this.telefone = telefone;
        this.tipoUsuario = tipoUsuario;
        this.reputacao = reputacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    
    public LocalDate getNascimento() {
        return nascimento;
    }
    
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
    
    public String getFotoUsuario() {
        return fotoUsuario;
    }
    
    public void setFotoUsuario(String fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public Integer getTipoUsuario() {
        return tipoUsuario;
    }
    
    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public Double getReputacao() {
        return reputacao;
    }
    
    public void setReputacao(Double reputacao) {
        this.reputacao = reputacao;
    }
}
