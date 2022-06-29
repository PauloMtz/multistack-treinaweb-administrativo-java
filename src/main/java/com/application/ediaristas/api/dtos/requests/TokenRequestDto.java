package com.application.ediaristas.api.dtos.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TokenRequestDto {
    
    @NotNull
    @NotEmpty
    @Email
    @Size(max = 100)
    private String email;

    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String senha;

    public TokenRequestDto() {
    }

    public TokenRequestDto(String email, String senha) {
        this.email = email;
        this.senha = senha;
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
}
