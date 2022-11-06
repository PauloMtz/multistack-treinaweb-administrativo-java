package com.application.ediaristas.api.dtos.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.application.ediaristas.core.enums.DiariaStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
public class DiariaResponseDto extends HateoasResponseDto {
    
    private Long id;

    private Integer status;

    private BigDecimal valorComissao;

    private String motivoCancelamento;

    private String nomeServico;

    private String complemento;

    private LocalDateTime dataAtendimento;

    private Integer tempoAtendimento;

    private BigDecimal preco;

    private String logradouro;

    private String numero;

    private String bairro;

    private String estado;

    private String codigoIbge;

    private Integer quantidadeQuartos;

    private Integer quantidadeSalas;

    private Integer quantidadeCozinhas;

    private Integer quantidadeBanheiros;

    private Integer quantidadeQuintais;

    private Integer quantidadeOutros;

    private String observacoes;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long servico;

    private UsuarioDiariaResponseDto cliente;

    private UsuarioDiariaResponseDto diarista;

    public DiariaResponseDto() {
    }

    public DiariaResponseDto(Long id, Integer status, BigDecimal valorComissao, 
        String motivoCancelamento, String nomeServico, String complemento, 
        LocalDateTime dataAtendimento, Integer tempoAtendimento,
        BigDecimal preco, String logradouro, String numero, String bairro, 
        String estado, String codigoIbge, Integer quantidadeQuartos, 
        Integer quantidadeSalas, Integer quantidadeCozinhas, Integer quantidadeBanheiros,
        Integer quantidadeQuintais, Integer quantidadeOutros, String observacoes, 
        LocalDateTime createdAt, LocalDateTime updatedAt, Long servico, 
        UsuarioDiariaResponseDto cliente, UsuarioDiariaResponseDto diarista) {

        this.id = id;
        this.status = status;
        this.valorComissao = valorComissao;
        this.motivoCancelamento = motivoCancelamento;
        this.nomeServico = nomeServico;
        this.complemento = complemento;
        this.dataAtendimento = dataAtendimento;
        this.tempoAtendimento = tempoAtendimento;
        this.preco = preco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.estado = estado;
        this.codigoIbge = codigoIbge;
        this.quantidadeQuartos = quantidadeQuartos;
        this.quantidadeSalas = quantidadeSalas;
        this.quantidadeCozinhas = quantidadeCozinhas;
        this.quantidadeBanheiros = quantidadeBanheiros;
        this.quantidadeQuintais = quantidadeQuintais;
        this.quantidadeOutros = quantidadeOutros;
        this.observacoes = observacoes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.servico = servico;
        this.cliente = cliente;
        this.diarista = diarista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getValorComissao() {
        return valorComissao;
    }

    public void setValorComissao(BigDecimal valorComissao) {
        this.valorComissao = valorComissao;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getServico() {
        return servico;
    }

    public void setServico(Long servico) {
        this.servico = servico;
    }

    public UsuarioDiariaResponseDto getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioDiariaResponseDto cliente) {
        this.cliente = cliente;
    }

    public UsuarioDiariaResponseDto getDiarista() {
        return diarista;
    }

    public void setDiarista(UsuarioDiariaResponseDto diarista) {
        this.diarista = diarista;
    }

    @JsonIgnore
    public Boolean isSemPagamento() {
        return status.equals(DiariaStatus.SEM_PAGAMENTO.getId());
    }

    @JsonIgnore
    public Boolean isConfirmado() {
        return status.equals(DiariaStatus.CONFIRMADO.getId());
    }

    @JsonIgnore
    public Boolean isConcluido() {
        return status.equals(DiariaStatus.CONCLUIDO.getId());
    }

    @JsonIgnore
    public boolean isPago() {
        return status.equals(DiariaStatus.PAGO.getId());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DiariaResponseDto other = (DiariaResponseDto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
