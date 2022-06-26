package com.application.ediaristas.core.services.token.adapters;

public interface TokenServiceAdapter {
    
    String gerarTokenAcesso(String subject);
    String getSubjectTokenAcesso(String TokenAcesso);

    // inserir no pom.xml a biblioteca 'jjwt', que irá gerar os tokens
}
