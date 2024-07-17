package com.deivid.financas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deivid.financas_api.model.MovimentoModel;

public interface MovimentoRepository extends JpaRepository<MovimentoModel, Long> {
    
}
