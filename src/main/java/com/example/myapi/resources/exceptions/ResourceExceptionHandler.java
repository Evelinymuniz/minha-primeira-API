package com.example.myapi.resources.exceptions;

import com.example.myapi.services.excepitions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<SandertErro> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
      SandertErro erro = new SandertErro(HttpStatus.NOT_FOUND.
              value(),System.currentTimeMillis(), e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

    }
}
