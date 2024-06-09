package com.insightlab.fornecedor.infra.exceptions;

import com.insightlab.fornecedor.exceptions.FornecedorDuplicateException;
import com.insightlab.fornecedor.exceptions.FornecedorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FornecedorNotFoundException.class)
    public ResponseEntity<RestErrorMessage> FornecedorNotFoundExceptiomHandler(Exception ex){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND.value(),ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(FornecedorDuplicateException.class)
    public ResponseEntity<RestErrorMessage> FornecedorDuplicateExceptionHandler(Exception ex){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.CONFLICT.value(), ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

}
