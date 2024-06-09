package com.insightlab.fornecedor.infra.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class RestErrorMessage {

    private int errorStatus;
    private String message;
    private LocalDateTime dateTime;

}
