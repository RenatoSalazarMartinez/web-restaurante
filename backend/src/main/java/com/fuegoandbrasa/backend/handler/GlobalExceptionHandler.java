package com.fuegoandbrasa.backend.handler;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice //Esta anotación le indica a Spring que esta clase actuará como un interceptor para todos tus controladores
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class) //Le dice a Spring que si algún controlador lanza un RuntimeException, lo derive automáticamente a este método.

    //ResponseEntity<String>: Es el contenedor de Spring que nos permite elegir el código de estado HTTP (como 404 Not Found, 400 Bad Request, etc.) y el cuerpo de la respuesta.
    public ResponseEntity<String> manejarRuntimeException(RuntimeException ex) { //Recibimos el error como parámetro para poder extraer el mensaje que escribiste en el servicio

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND) //Configura el código de estado HTTP a 404
            .body(ex.getMessage()); //Extrae el texto exacto que se escribio en el orElseThrow del servicio
    }
}
