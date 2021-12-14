package com.application.ediaristas.web.dtos;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.application.ediaristas.core.enums.Icone;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class ServicoForm {

    /*
        [ no VsCode ]
        Alt + Shift + 'o' para organizar imports
    */
    
    @NotNull
    @Size(min = 3, max = 50)
    private String nome;

    @NotNull
    @PositiveOrZero
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorMinimo;

    @NotNull
    @PositiveOrZero
    private Integer qtdeHoras;

    @NotNull
    @PositiveOrZero
    @Max(100)
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal comissao;

    @NotNull
    @PositiveOrZero
    private Integer horasQuarto;

    @NotNull
    @PositiveOrZero
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorQuarto;

    @NotNull
    @PositiveOrZero
    private Integer horasSala;

    @NotNull
    @PositiveOrZero
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorSala;

    @NotNull
    @PositiveOrZero
    private Integer horasBanheiro;

    @NotNull
    @PositiveOrZero
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorBanheiro;

    @NotNull
    @PositiveOrZero
    private Integer horasCozinha;

    @NotNull
    @PositiveOrZero
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorCozinha;

    @NotNull
    @PositiveOrZero
    private Integer horasQuintal;

    @NotNull
    @PositiveOrZero
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorQuintal;

    @NotNull
    @PositiveOrZero
    private Integer horasOutros;

    @NotNull
    @PositiveOrZero
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorOutros;

    @NotNull
    private Icone icone;

    @NotNull
    @Positive
    private Integer posicao;

    // [ no VsCode ] digita 'ctor' e dá 'ENTER'
    public ServicoForm() {
    }
    
    /*
        [ no VsCode ]
        clica com o botão direito do mouse --> seleciona 'Source Action' 
        --> seleciona 'Generate Constructors...'
        --> demais opções: getters e setters, equals() e hashCode() etc.
    */
    public ServicoForm(String nome, BigDecimal valorMinimo, Integer qtdeHoras, BigDecimal comissao, Integer horasQuarto,
            BigDecimal valorQuarto, Integer horasSala, BigDecimal valorSala, Integer horasBanheiro,
            BigDecimal valorBanheiro, Integer horasCozinha, BigDecimal valorCozinha, Integer horasQuintal,
            BigDecimal valorQuintal, Integer horasOutros, BigDecimal valorOutros, Icone icone, Integer posicao) {
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

    public Icone getIcone() {
        return icone;
    }

    public void setIcone(Icone icone) {
        this.icone = icone;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }
}
