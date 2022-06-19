package com.application.ediaristas.core.services.email.dtos;

import java.util.Map;

public class EmailServiceParamsDto {
    
    private String destinatario;
    private String assunto;
    private String template;
    private Map<String, Object> props;

    public EmailServiceParamsDto() {
    }

    public EmailServiceParamsDto(String destinatario, String assunto, String template, Map<String, Object> props) {
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.template = template;
        this.props = props;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Map<String, Object> getProps() {
        return props;
    }

    public void setProps(Map<String, Object> props) {
        this.props = props;
    }
}
