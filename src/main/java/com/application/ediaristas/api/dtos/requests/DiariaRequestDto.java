package com.application.ediaristas.api.dtos.requests;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import com.application.ediaristas.core.validators.HoraDepoisDe;
import com.application.ediaristas.core.validators.ServicoExistsById;

@JsonNaming(SnakeCaseStrategy.class)
public class DiariaRequestDto {
    
    @NotNull
    @Future
    @HoraDepoisDe(horaInicio = 6)
    private LocalDateTime dataAtendimento;

    @NotNull
    @Positive
    private Integer tempoAtendimento;

    @NotNull
    @Positive
    private BigDecimal preco;

    @NotNull // valida que o campo enviou alguma coisa
    @NotEmpty // valida se string não contém apenas espaços, isso passaria pelo not null
    @Size(max = 60)
    private String logradouro;

    @NotNull
    @NotEmpty
    @Size(max = 10)
    private String numero;

    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String bairro;

    @Size(max = 100)
    private String complemento;

    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String cidade;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 2)
    private String estado;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 8)
    private String cep;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String codigoIbge;

    @NotNull
    @PositiveOrZero
    private Integer quantidadeQuartos;

    @NotNull
    @PositiveOrZero
    private Integer quantidadeSalas;

    @NotNull
    @PositiveOrZero
    private Integer quantidadeCozinhas;

    @NotNull
    @PositiveOrZero
    private Integer quantidadeBanheiros;

    @NotNull
    @PositiveOrZero
    private Integer quantidadeQuintais;

    @NotNull
    @PositiveOrZero
    private Integer quantidadeOutros;

    @Size(max = 255)
    private String observacoes;

    @NotNull
    @Positive
    @ServicoExistsById
    private Long servico;

    public DiariaRequestDto() {
    }

    public DiariaRequestDto(LocalDateTime dataAtendimento, Integer tempoAtendimento,
            BigDecimal preco, String logradouro, String numero, String bairro,
            String complemento, String cidade, String estado, String cep,
            String codigoIbge, Integer quantidadeQuartos,
            Integer quantidadeSalas, Integer quantidadeCozinhas,
            Integer quantidadeBanheiros, Integer quantidadeQuintais,
            Integer quantidadeOutros, String observacoes, Long servico) {
        this.dataAtendimento = dataAtendimento;
        this.tempoAtendimento = tempoAtendimento;
        this.preco = preco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.codigoIbge = codigoIbge;
        this.quantidadeQuartos = quantidadeQuartos;
        this.quantidadeSalas = quantidadeSalas;
        this.quantidadeCozinhas = quantidadeCozinhas;
        this.quantidadeBanheiros = quantidadeBanheiros;
        this.quantidadeQuintais = quantidadeQuintais;
        this.quantidadeOutros = quantidadeOutros;
        this.observacoes = observacoes;
        this.servico = servico;
    }

    public LocalDateTime getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDateTime dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Integer getTempoAtendimento() {
        return tempoAtendimento;
    }

    public void setTempoAtendimento(Integer tempoAtendimento) {
        this.tempoAtendimento = tempoAtendimento;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(String codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public Integer getQuantidadeQuartos() {
        return quantidadeQuartos;
    }

    public void setQuantidadeQuartos(Integer quantidadeQuartos) {
        this.quantidadeQuartos = quantidadeQuartos;
    }

    public Integer getQuantidadeSalas() {
        return quantidadeSalas;
    }

    public void setQuantidadeSalas(Integer quantidadeSalas) {
        this.quantidadeSalas = quantidadeSalas;
    }

    public Integer getQuantidadeCozinhas() {
        return quantidadeCozinhas;
    }

    public void setQuantidadeCozinhas(Integer quantidadeCozinhas) {
        this.quantidadeCozinhas = quantidadeCozinhas;
    }

    public Integer getQuantidadeBanheiros() {
        return quantidadeBanheiros;
    }

    public void setQuantidadeBanheiros(Integer quantidadeBanheiros) {
        this.quantidadeBanheiros = quantidadeBanheiros;
    }

    public Integer getQuantidadeQuintais() {
        return quantidadeQuintais;
    }

    public void setQuantidadeQuintais(Integer quantidadeQuintais) {
        this.quantidadeQuintais = quantidadeQuintais;
    }

    public Integer getQuantidadeOutros() {
        return quantidadeOutros;
    }

    public void setQuantidadeOutros(Integer quantidadeOutros) {
        this.quantidadeOutros = quantidadeOutros;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Long getServico() {
        return servico;
    }

    public void setServico(Long servico) {
        this.servico = servico;
    }
}
