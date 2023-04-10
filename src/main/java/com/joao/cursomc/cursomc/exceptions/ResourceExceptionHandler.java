package com.joao.cursomc.cursomc.exceptions;

import com.joao.cursomc.cursomc.services.exceptions.DataIntegrityException;
import com.joao.cursomc.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException objectNotFoundException, HttpServletRequest httpServletRequest){
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), objectNotFoundException.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> objectNotFound(DataIntegrityException dataIntegrityException, HttpServletRequest httpServletRequest){
        StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), dataIntegrityException.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest httpServletRequest){
        ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação", System.currentTimeMillis());
        for(FieldError x : methodArgumentNotValidException.getBindingResult().getFieldErrors()){
            error.addError(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
