package com.insightlab.fornecedor.repositories;

import com.insightlab.fornecedor.domain.Fornecedor;
import com.insightlab.fornecedor.dtos.DetailFornecedorDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor,String> {
    List<Fornecedor> getAllByIsActiveTrue();

    Fornecedor getFornecedorByIdAndIsActiveTrue(String id);

    boolean existsByNameAndIsActiveTrue(String name);
}
