package com.application.ediaristas.api.dtos.responses;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
public class ServicoResponseDto {
   
    Long id;
    private String nome;
    private BigDecimal valorMinimo;
    private Integer qtdeHoras;
    private BigDecimal comissao;
    private Integer horasQuarto;
    private BigDecimal valorQuarto;
    private Integer horasSala;
    private BigDecimal valorSala;
    private Integer horasBanheiro;
    private BigDecimal valorBanheiro;
    private Integer horasCozinha;
    private BigDecimal valorCozinha;
    private Integer horasQuintal;
    private BigDecimal valorQuintal;
    private Integer horasOutros;
    private BigDecimal valorOutros;
    private String icone;
    private Integer posicao;

    public ServicoResponseDto() {
    }

    public ServicoResponseDto(Long id, String nome, BigDecimal valorMinimo, 
            Integer qtdeHoras, BigDecimal comissao, Integer horasQuarto, 
            BigDecimal valorQuarto, Integer horasSala, BigDecimal valorSala, 
            Integer horasBanheiro, BigDecimal valorBanheiro, Integer horasCozinha, 
            BigDecimal valorCozinha, Integer horasQuintal, BigDecimal valorQuintal, 
            Integer horasOutros, BigDecimal valorOutros, String icone, Integer posicao) {
        this.id = id;
        this.nome = nome;
        this.valorMinimo = valorMinimo;
        this.qtdeHoras = qtdeHoras;
        this.comissao = comissao;
        this.horasQuarto = horasQuarto;
        this.valorQuarto = valorQuarto;
        this.horasSala = horasSala;
        this.valorSala = valorSala;
        this.horasBanheiro = horasBanheiro;
        this.valorBanheiro = valorBanheiro;
        this.horasCozinha = horasCozinha;
        this.valorCozinha = valorCozinha;
        this.horasQuintal = horasQuintal;
        this.valorQuintal = valorQuintal;
        this.horasOutros = horasOutros;
        this.valorOutros = valorOutros;
        this.icone = icone;
        this.posicao = posicao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(BigDecimal valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public Integer getQtdeHoras() {
        return qtdeHoras;
    }

    public void setQtdeHoras(Integer qtdeHoras) {
        this.qtdeHoras = qtdeHoras;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public Integer getHorasQuarto() {
        return horasQuarto;
    }

    public void setHorasQuarto(Integer horasQuarto) {
        this.horasQuarto = horasQuarto;
    }

    public BigDecimal getValorQuarto() {
        return valorQuarto;
    }

    public void setValorQuarto(BigDecimal valorQuarto) {
        this.valorQuarto = valorQuarto;
    }

    public Integer getHorasSala() {
        return horasSala;
    }

    public void setHorasSala(Integer horasSala) {
        this.horasSala = horasSala;
    }

    public BigDecimal getValorSala() {
        return valorSala;
    }

    public void setValorSala(BigDecimal valorSala) {
        this.valorSala = valorSala;
    }

    public Integer getHorasBanheiro() {
        return horasBanheiro;
    }

    public void setHorasBanheiro(Integer horasBanheiro) {
        this.horasBanheiro = horasBanheiro;
    }

    public BigDecimal getValorBanheiro() {
        return valorBanheiro;
    }

    public void setValorBanheiro(BigDecimal valorBanheiro) {
        this.valorBanheiro = valorBanheiro;
    }

    public Integer getHorasCozinha() {
        return horasCozinha;
    }

    public void setHorasCozinha(Integer horasCozinha) {
        this.horasCozinha = horasCozinha;
    }

    public BigDecimal getValorCozinha() {
        return valorCozinha;
    }

    public void setValorCozinha(BigDecimal valorCozinha) {
        this.valorCozinha = valorCozinha;
    }

    public Integer getHorasQuintal() {
        return horasQuintal;
    }

    public void setHorasQuintal(Integer horasQuintal) {
        this.horasQuintal = horasQuintal;
    }

    public BigDecimal getValorQuintal() {
        return valorQuintal;
    }

    public void setValorQuintal(BigDecimal valorQuintal) {
        this.valorQuintal = valorQuintal;
    }

    public Integer getHorasOutros() {
        return horasOutros;
    }

    public void setHorasOutros(Integer horasOutros) {
        this.horasOutros = horasOutros;
    }

    public BigDecimal getValorOutros() {
        return valorOutros;
    }

    public void setValorOutros(BigDecimal valorOutros) {
        this.valorOutros = valorOutros;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }
}
