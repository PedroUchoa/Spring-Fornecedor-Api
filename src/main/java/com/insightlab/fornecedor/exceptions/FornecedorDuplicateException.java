package com.insightlab.fornecedor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Já tem um usuario com o mesmo nome")
public class FornecedorDuplicateException extends RuntimeException{

    public FornecedorDuplicateException(String msg){
        super(msg);
    }

}
