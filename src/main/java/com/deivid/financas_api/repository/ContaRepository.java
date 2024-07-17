package com.deivid.financas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deivid.financas_api.model.ContaModel;

public interface ContaRepository extends JpaRepository<ContaModel, Long> {
    
}
