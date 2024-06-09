package com.insightlab.fornecedor.dtos;

import com.insightlab.fornecedor.domain.Fornecedor;

import java.time.LocalDateTime;
import java.util.Date;

public record DetailFornecedorDTO(String id, String name, String email, String phone, LocalDateTime startDate) {

    public DetailFornecedorDTO(Fornecedor fornecedor){
        this(fornecedor.getId(), fornecedor.getName(), fornecedor.getEmail(), fornecedor.getPhone(), fornecedor.getStartDate());
    }

}
