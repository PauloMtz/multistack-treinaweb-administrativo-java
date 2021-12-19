package com.application.ediaristas.web.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioCadastroForm {

    @NotNull
    @Size(min = 3, max = 255)
    private String nomeCompleto;

    @NotNull
    @Size(min = 3, max = 255)
    @Email
    private String email;

    @NotNull
    @NotEmpty
    private String senha;

    @NotNull
    @NotEmpty
    private String confirmacaoSenha;

    public UsuarioCadastroForm() {
    }

    public UsuarioCadastroForm(@NotNull @Size(min = 3, max = 255) String nomeCompleto,
            @NotNull @Size(min = 3, max = 255) @Email String email, @NotNull @NotEmpty String senha,
            @NotNull @NotEmpty String confirmacaoSenha) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.confirmacaoSenha = confirmacaoSenha;
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

    public String getConfirmacaoSenha() {
        return confirmacaoSenha;
    }

    public void setConfirmacaoSenha(String confirmacaoSenha) {
        this.confirmacaoSenha = confirmacaoSenha;
    } 
}