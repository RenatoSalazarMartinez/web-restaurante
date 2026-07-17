package com.fuegoandbrasa.backend.handler;

import java.time.LocalDateTime;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import com.fuegoandbrasa.backend.exceptions.ValidacionException;

@RestControllerAdvice //Esta anotación le indica a Spring que esta clase actuará como un interceptor para todos tus controladores
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class) //Le dice a Spring que si algún controlador lanza un RuntimeException, lo derive automáticamente a este método.

    //ResponseEntity<String>: Es el contenedor de Spring que nos permite elegir el código de estado HTTP (como 404 Not Found, 400 Bad Request, etc.) y el cuerpo de la respuesta.
    public ResponseEntity<ErrorResponse> manejarRuntimeException(RuntimeException ex, WebRequest request) { //Recibimos el error como parámetro para poder extraer el mensaje que escribiste en el servicio
        ErrorResponse error = new ErrorResponse();
        
        error.setTimestamp(LocalDateTime.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setPath(request.getDescription(false)); //extraemos la URL exacta que falló

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(error);
    }

    @ExceptionHandler(ValidacionException.class) // Captura específicamente la nueva excepción
    public ResponseEntity<ErrorResponse> manejarValidacionException(ValidacionException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse();
    
        error.setTimestamp(LocalDateTime.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value()); //Código 400
        error.setMessage(ex.getMessage());
        error.setPath(request.getDescription(false));

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST) // Respuesta HTTP 400
            .body(error);
}
}
 