package com.application.ediaristas.core.exceptions;

public class TokenBlackListException extends RuntimeException {

    public TokenBlackListException() {
        super("Este token já não é mais válido.");
    }

    public TokenBlackListException(String message) {
        super(message);
    }
    
}
