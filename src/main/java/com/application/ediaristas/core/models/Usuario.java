package com.application.ediaristas.core.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(name = "tipo_usuario", length = 8)
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @Column(nullable = true, unique = true, length = 11)
    private String cpf;

    @Column(nullable = true)
    private LocalDate nascimento;

    @Column(nullable = true, length = 11)
    private String telefone;

    @Column(nullable = true)
    private Double reputacao;

    @Column(name = "chave_pix", nullable = true, unique = true)
    private String chavePix;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "foto_documento", nullable = true)
    private Foto fotoDocumento;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "foto_usuario", nullable = true)
    private Foto fotoUsuario;

    @ManyToMany
    @JoinTable(
        name = "cidades_usuarios",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "cidade_id")
    )
    private List<CidadeAtendida> cidadesAtendidas;

    public Usuario() {
    }

    public Usuario(Long id, String nomeCompleto, String email, String senha, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Double getReputacao() {
        return reputacao;
    }

    public void setReputacao(Double reputacao) {
        this.reputacao = reputacao;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public Foto getFotoDocumento() {
        return fotoDocumento;
    }

    public void setFotoDocumento(Foto fotoDocumento) {
        this.fotoDocumento = fotoDocumento;
    }

    public Foto getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(Foto fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }

    public List<CidadeAtendida> getCidadesAtendidas() {
        return cidadesAtendidas;
    }

    public void setCidadesAtendidas(List<CidadeAtendida> cidadesAtendidas) {
        this.cidadesAtendidas = cidadesAtendidas;
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
        Usuario other = (Usuario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Usuario [fotoUsuario=" + fotoUsuario + ", id=" + id + ", nascimento=" + nascimento + ", nomeCompleto="
                + nomeCompleto + ", reputacao=" + reputacao + ", tipoUsuario=" + tipoUsuario + "]";
    }

    public Boolean isDiarista() {
        return tipoUsuario.equals(TipoUsuario.DIARISTA);
    }

    public Boolean isCliente() {
        return tipoUsuario.equals(TipoUsuario.CLIENTE);
    }

    public Boolean isAdmin() {
        return tipoUsuario.equals(TipoUsuario.ADMIN);
    }
}
