package com.insightlab.fornecedor.domain;

import com.insightlab.fornecedor.dtos.CreateFornecedorDTO;
import com.insightlab.fornecedor.dtos.DetailFornecedorDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "fornecedores")
@Entity(name = "fornecedor")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String email;
    private String phone;
    @CreationTimestamp
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean isActive;

    public Fornecedor(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.isActive = true;
    }

    public Fornecedor(CreateFornecedorDTO fornecedorDTO) {
        this.name = fornecedorDTO.name();
        this.email = fornecedorDTO.email();
        this.phone = fornecedorDTO.phone();
        this.isActive = true;
    }

    public void desactiveFornecedor() {
        setIsActive(false);
        setEndDate(LocalDateTime.now());
    }

    public void updateFornecedor(CreateFornecedorDTO updateFornecedor) {
        if(updateFornecedor.name() != null && !updateFornecedor.name().isEmpty()){
            setName(updateFornecedor.name());
        }
        if(updateFornecedor.email() != null && !updateFornecedor.email().isEmpty()){
            setEmail(updateFornecedor.email());
        }
        if(updateFornecedor.phone() != null && !updateFornecedor.phone().isEmpty()){
            setPhone(updateFornecedor.phone());
        }
    }
}
