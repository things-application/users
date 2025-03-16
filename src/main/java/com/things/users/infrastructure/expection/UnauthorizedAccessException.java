package com.things.users.infrastructure.expection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Define a exceção personalizada para acesso não autorizado
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedAccessException extends RuntimeException {

    // Construtor que aceita uma mensagem personalizada
    public UnauthorizedAccessException(String message) {
        super(message);
    }

    // Construtor que aceita uma mensagem personalizada e uma causa
    public UnauthorizedAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
