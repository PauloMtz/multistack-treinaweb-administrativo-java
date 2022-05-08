package com.application.ediaristas.api.dtos.requests;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class UsuarioRequestDto {
    
    @NotNull
    @Size(min = 3, max = 100)
    private String nomeCompleto;

    @NotNull
    @Size(max = 100)
    @Email
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String passwordConfirmation;

    @NotNull
    private Integer tipoUsuario;

    @NotNull
    @Size(min = 11, max = 11)
    @CPF
    private String cpf;

    @NotNull
    @Past
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate nascimento;

    @NotNull
    @Size(min = 11, max = 11)
    private String telefone;

    @Size(min = 11, max = 100)
    private String chavePix;

    public UsuarioRequestDto() {
    }

    public UsuarioRequestDto(String nomeCompleto, String email, String password, String passwordConfirmation,
            Integer tipoUsuario, String cpf, LocalDate nascimento, String telefone, String chavePix) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.tipoUsuario = tipoUsuario;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.chavePix = chavePix;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
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

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    } 
}
