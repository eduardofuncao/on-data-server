package br.com.fiap.on_data.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(PacienteNotFoundException.class)
    public ResponseEntity<Map<String, String>> PacienteNotFound(PacienteNotFoundException e) {
        Map<String, String> response = Map.of("status", "404", "message", e.getMessage());
        return ResponseEntity.status(404).body(response);
    }

    @ExceptionHandler(DuplicatePacienteException.class)
    public ResponseEntity<Map<String, String>> DuplicatePaciente(PacienteNotFoundException e) {
        Map<String, String> response = Map.of("status", "409", "message", e.getMessage());
        return ResponseEntity.status(409).body(response);
    }
}