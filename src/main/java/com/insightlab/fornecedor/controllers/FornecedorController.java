package com.insightlab.fornecedor.controllers;

import com.insightlab.fornecedor.dtos.CreateFornecedorDTO;
import com.insightlab.fornecedor.dtos.DetailFornecedorDTO;
import com.insightlab.fornecedor.services.FornecedorService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/fornecedor")
public class FornecedorController {

    private FornecedorService service;

    public FornecedorController(FornecedorService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<Void> createFornecedor(@RequestBody CreateFornecedorDTO fornecedorDTO){
        service.createFornecedor(fornecedorDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<DetailFornecedorDTO>> getAllFornecedores(){
        List<DetailFornecedorDTO> fornecedores = service.getAllFornecedores();
        return ResponseEntity.ok().body(fornecedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailFornecedorDTO> getFornecedorById(@PathVariable String id){
        DetailFornecedorDTO fornecedorDTO = service.getFornecedorById(id);
        return ResponseEntity.ok().body(fornecedorDTO);
    }

    @PutMapping("/update/{id}")
    @Transactional
    public ResponseEntity<Void> updateFornecedor(@PathVariable String id, @RequestBody CreateFornecedorDTO fornecedorDTO){
        service.updateFornecedor(id,fornecedorDTO);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<Void> deleteFornecedor(@PathVariable String id){
        service.deleteFornecedor(id);
        return ResponseEntity.noContent().build();
    }

}
