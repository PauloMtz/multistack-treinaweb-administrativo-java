package com.application.ediaristas.core.exceptions;

public class TokenBlackListException extends RuntimeException {

    public TokenBlackListException() {
        super("Token invalidado.");
    }

    public TokenBlackListException(String message) {
        super(message);
    }
    
}
