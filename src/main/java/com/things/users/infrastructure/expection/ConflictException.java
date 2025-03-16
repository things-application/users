package com.things.users.infrastructure.expection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Define uma exceção personalizada para conflitos
@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {

    // Construtor que aceita uma mensagem personalizada
    public ConflictException(String message) {
        super(message);
    }

    // Construtor que aceita uma mensagem personalizada e uma causa
    public ConflictException(String message, Throwable cause) {
        super(message, cause);
    }
}