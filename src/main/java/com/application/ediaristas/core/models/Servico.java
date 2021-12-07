package com.application.ediaristas.core.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.application.ediaristas.core.enums.Icone;

@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(name = "valor_minimo", nullable = false)
    private BigDecimal valorMinimo;

    @Column(name = "qtde_horas", nullable = false)
    private Integer qtdeHoras;

    @Column(nullable = false)
    private BigDecimal comissao;

    @Column(name = "horas_quarto", nullable = false)
    private Integer horasQuarto;

    @Column(name = "valor_quarto", nullable = false)
    private BigDecimal valorQuarto;

    @Column(name = "horas_salar", nullable = false)
    private Integer horasSala;

    @Column(name = "valor_sala", nullable = false)
    private BigDecimal valorSala;

    @Column(name = "horas_banheiro", nullable = false)
    private Integer horasBanheiro;

    @Column(name = "valor_banheiro", nullable = false)
    private BigDecimal valorBanheiro;

    @Column(name = "horas_cozinha", nullable = false)
    private Integer horasCozinha;

    @Column(name = "valor_cozinha", nullable = false)
    private BigDecimal valorCozinha;

    @Column(name = "horas_quintal", nullable = false)
    private Integer horasQuintal;

    @Column(name = "valor_quintal", nullable = false)
    private BigDecimal valorQuintal;

    @Column(name = "horas_outros", nullable = false)
    private Integer horasOutros;

    @Column(name = "valor_outros", nullable = false)
    private BigDecimal valorOutros;

    @Enumerated(EnumType.STRING)
    @Column(length = 14, nullable = false)
    private Icone icone;

    @Column(nullable = false)
    private Integer posicao;

    // [ no VsCode ] digita 'ctor' e dá 'ENTER'
    public Servico() {
    }

    /*
        [ no VsCode ]
        clica com o botão direito do mouse --> seleciona 'Source Action' 
        --> seleciona 'Generate Constructors...'
    */
    public Servico(Long id, String nome, BigDecimal valorMinimo, Integer qtdeHoras, BigDecimal comissao,
            Integer horasQuarto, BigDecimal valorQuarto, Integer horasSala, BigDecimal valorSala, Integer horasBanheiro,
            BigDecimal valorBanheiro, Integer horasCozinha, BigDecimal valorCozinha, Integer horasQuintal,
            BigDecimal valorQuintal, Integer horasOutros, BigDecimal valorOutros, Icone icone, Integer posicao) {
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

    /*
        [ no VsCode ]
        clica com o botão direito do mouse --> seleciona 'Source Action' 
        --> seleciona 'Generate Getters and Setters'
    */
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

    /*
        [ no VsCode ]
        clica com o botão direito do mouse --> seleciona 'Source Action' 
        --> seleciona 'Generate HashCode() and Equals()'
    */
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
        Servico other = (Servico) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
