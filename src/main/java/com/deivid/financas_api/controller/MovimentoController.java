package com.deivid.financas_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deivid.financas_api.model.MovimentoModel;
import com.deivid.financas_api.model.SaldoModel;
import com.deivid.financas_api.repository.MovimentoRepository;

@RestController
@RequestMapping("/")
public class MovimentoController {
    
    @Autowired
    private MovimentoRepository movimentoRepository;

    @PostMapping("/addMovimento")
    public ResponseEntity<MovimentoModel> addMovimento(@RequestBody MovimentoModel movimento) {
        MovimentoModel novoMovimento = movimentoRepository.save(movimento);

        return ResponseEntity.ok(novoMovimento);        
    }

    @GetMapping("/saldo")
    public ResponseEntity<SaldoModel> saldo() {
        Double total = 0.0;

        for(MovimentoModel mov : movimentoRepository.findAll()){
            if(mov.getTipo().equals("C")) {
                total = total + mov.getValor(); 
            } else {
                total = total - mov.getValor(); 
            }
        }

        SaldoModel saldoModel = new SaldoModel();
        saldoModel.setSaldo(total);

        return ResponseEntity.ok(saldoModel);
    }

    @GetMapping("/aPagar")
    public ResponseEntity<List<MovimentoModel>> aPagar() {
        List<MovimentoModel> movimentoAPagar = new ArrayList<>();

        for(MovimentoModel mov : movimentoRepository.findAll()){
            if(mov.getValor().compareTo(mov.getValorPago()) > 0) {
                movimentoAPagar.add(mov);
            }
        }

        return ResponseEntity.ok(movimentoAPagar);
    }

    @PutMapping("/pagar")
    public ResponseEntity<MovimentoModel> pagar(@RequestBody MovimentoModel movimentoModel) {
        
        MovimentoModel atualMovimento = new MovimentoModel();
        atualMovimento.setId(movimentoModel.getId());
        atualMovimento.setData(movimentoModel.getData());
        atualMovimento.setConta(movimentoModel.getConta());
        atualMovimento.setTipo(movimentoModel.getTipo());
        atualMovimento.setValor(movimentoModel.getValor());
        atualMovimento.setValorPago(movimentoModel.getValorPago());

        movimentoRepository.save(atualMovimento);
        return ResponseEntity.ok(atualMovimento);
    }
}
