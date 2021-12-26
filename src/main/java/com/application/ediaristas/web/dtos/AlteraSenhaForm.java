package com.application.ediaristas.web.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AlteraSenhaForm {
    
    @NotNull
    @NotEmpty
    private String senhaAntiga;

    @NotNull
    @NotEmpty
    private String senha;

    @NotNull
    @NotEmpty
    private String confirmacaoSenha;

    public AlteraSenhaForm() {
    }

    public AlteraSenhaForm(String senhaAntiga, String senha, String confirmacaoSenha) {
        this.senhaAntiga = senhaAntiga;
        this.senha = senha;
        this.confirmacaoSenha = confirmacaoSenha;
    }

    public String getSenhaAntiga() {
        return senhaAntiga;
    }

    public void setSenhaAntiga(String senhaAntiga) {
        this.senhaAntiga = senhaAntiga;
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
