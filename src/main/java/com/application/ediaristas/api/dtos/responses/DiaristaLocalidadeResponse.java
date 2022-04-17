package com.application.ediaristas.api.dtos.responses;

public class DiaristaLocalidadeResponse {
    
    private String nomeCompleto;
    private Double reputacao;
    // na classe de domínio, essa fotoUsuario é do tipo Foto
    // essa conversão será feita na ApiDiaristaMapper
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
}
