package com.insightlab.fornecedor.services;

import com.insightlab.fornecedor.domain.Fornecedor;
import com.insightlab.fornecedor.dtos.CreateFornecedorDTO;
import com.insightlab.fornecedor.dtos.DetailFornecedorDTO;
import com.insightlab.fornecedor.exceptions.FornecedorDuplicateException;
import com.insightlab.fornecedor.exceptions.FornecedorNotFoundException;
import com.insightlab.fornecedor.repositories.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    private FornecedorRepository repository;

    public FornecedorService(FornecedorRepository repository) {
        this.repository = repository;
    }

    public void createFornecedor(CreateFornecedorDTO fornecedorDTO){
        if(repository.existsByNameAndIsActiveTrue(fornecedorDTO.name())) throw new FornecedorDuplicateException("Fornecedor com o nome: " + fornecedorDTO.name() + " Já existe no banco de dadosp");
        Fornecedor fornecedor = new Fornecedor(fornecedorDTO);
        repository.save(fornecedor);
    }

    public List<DetailFornecedorDTO> getAllFornecedores(){
        return repository.getAllByIsActiveTrue().stream().map(DetailFornecedorDTO::new).toList();
    }

    public DetailFornecedorDTO getFornecedorById(String id){
        Fornecedor fornecedor = repository.getFornecedorByIdAndIsActiveTrue(id);
        if(fornecedor == null) throw new FornecedorNotFoundException("Fornecedor with id: " + id + " Not Found");
        return new DetailFornecedorDTO(fornecedor);
    }

    public void updateFornecedor(String id, CreateFornecedorDTO updateFornecedor){
        Fornecedor fornecedor = repository.getFornecedorByIdAndIsActiveTrue(id);
        if(fornecedor == null) throw new FornecedorNotFoundException("Fornecedor with id: " + id + " Not Found");
        if (repository.existsByNameAndIsActiveTrue(fornecedor.getName())) throw new FornecedorDuplicateException("Não é possivel atualizar o fornecedor pois já existe um fornecedor com o nome : " + updateFornecedor.name());
        fornecedor.updateFornecedor(updateFornecedor);
        repository.save(fornecedor);
    }

    public void deleteFornecedor(String id){
        Fornecedor fornecedor = repository.getFornecedorByIdAndIsActiveTrue(id);
        if(fornecedor.getIsActive()){
            fornecedor.desactiveFornecedor();
        }
        repository.save(fornecedor);
    }

}
