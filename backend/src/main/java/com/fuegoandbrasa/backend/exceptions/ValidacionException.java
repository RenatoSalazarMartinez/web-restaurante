package com.fuegoandbrasa.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) // Esto fuerza el código 400
public class ValidacionException extends RuntimeException {
    
    public ValidacionException(String mensaje) {
        super(mensaje);
    }
}