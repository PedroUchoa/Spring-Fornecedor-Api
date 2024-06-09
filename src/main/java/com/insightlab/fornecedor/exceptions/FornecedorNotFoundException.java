package com.insightlab.fornecedor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Fornecedor Não Encontrado no Banco de dados")
public class FornecedorNotFoundException extends RuntimeException{

    public FornecedorNotFoundException(String msg){
        super(msg);
    }


}
