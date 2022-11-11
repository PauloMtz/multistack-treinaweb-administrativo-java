package com.application.ediaristas.core.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.application.ediaristas.core.enums.DiariaStatus;

@Entity
public class Diaria extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_atendimento", nullable = false)
    private LocalDateTime dataAtendimento;

    @Column(name = "tempo_atendimento", nullable = false)
    private Integer tempoAtendimento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DiariaStatus status;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(name = "valor_comissao", nullable = false)
    private BigDecimal valorComissao;

    @Column(nullable = false, length = 60)
    private String logradouro;

    @Column(nullable = false, length = 10)
    private String numero;

    @Column(nullable = false, length = 30)
    private String bairro;

    @Column(nullable = true, length = 100)
    private String complemento;

    @Column(nullable = false, length = 30)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String estado;

    @Column(nullable = false, length = 8)
    private String cep;

    @Column(nullable = false)
    private String codigoIbge;

    @Column(name = "quantidade_quartos", nullable = false)
    private Integer quantidadeQuartos;

    @Column(name = "quantidade_salas", nullable = false)
    private Integer quantidadeSalas;

    @Column(name = "quantidade_cozinhas", nullable = false)
    private Integer quantidadeCozinhas;

    @Column(name = "quantidade_banheiros", nullable = false)
    private Integer quantidadeBanheiros;

    @Column(name = "quantidade_quintais", nullable = false)
    private Integer quantidadeQuintais;

    @Column(name = "quantidade_outros", nullable = false)
    private Integer quantidadeOutros;

    @Column(nullable = true)
    private String observacoes;

    @Column(name = "motivo_cancelamento" ,nullable = true)
    private String motivoCancelamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "diarista_id", nullable = true)
    private Usuario diarista;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;

    @ManyToMany
    @JoinTable(
        name = "diaria_candidato",
        joinColumns = @JoinColumn(name = "diaria_id"),
        inverseJoinColumns = @JoinColumn(name = "candidato_id")
    )
    private List<Usuario> candidatos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public DiariaStatus getStatus() {
        return status;
    }

    public void setStatus(DiariaStatus status) {
        this.status = status;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getValorComissao() {
        return valorComissao;
    }

    public void setValorComissao(BigDecimal valorComissao) {
        this.valorComissao = valorComissao;
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

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Usuario getDiarista() {
        return diarista;
    }

    public void setDiarista(Usuario diarista) {
        this.diarista = diarista;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public List<Usuario> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Usuario> candidatos) {
        this.candidatos = candidatos;
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
        Diaria other = (Diaria) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Diaria [candidatos = " + candidatos + ", cidade = " 
            + cidade + ", cliente = " + cliente + ", diarista = "
            + diarista + ", id = " + id + ", preco = " 
            + preco + ", servico = " + servico + "]";
    }

    public Boolean isSemPagamento() {
        return status.equals(DiariaStatus.SEM_PAGAMENTO);
    }
}
