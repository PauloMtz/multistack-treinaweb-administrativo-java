package com.application.ediaristas.web.dtos;

public class FlashMessage {

    private String classeCss;
    private String mensagem;

    public FlashMessage() {
    }
    
    public FlashMessage(String classeCss, String mensagem) {
        this.classeCss = classeCss;
        this.mensagem = mensagem;
    }

    public String getClasseCss() {
        return classeCss;
    }
    public void setClasseCss(String classeCss) {
        this.classeCss = classeCss;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
}
