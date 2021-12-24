package com.application.ediaristas.core.exceptions;

import org.springframework.validation.FieldError;

public class EmailJaCadastradoException extends ValidacaoException {

    public EmailJaCadastradoException(String message, FieldError fieldError) {
        super(message, fieldError);
    }
    
}
