package com.deivid.financas_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deivid.financas_api.model.ContaModel;
import com.deivid.financas_api.repository.ContaRepository;

@RestController
@RequestMapping("/")
public class ContaController {
    
    @Autowired
    private ContaRepository contaRepository;

    @PostMapping("/addConta")
    public ResponseEntity<ContaModel> addConta(@RequestBody ContaModel conta) {
        ContaModel novaConta = contaRepository.save(conta);
        
        return ResponseEntity.ok(novaConta);
    }
}
