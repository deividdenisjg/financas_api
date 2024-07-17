package com.deivid.financas_api.model;

public class SaldoModel {
    
    private Double saldo;
    
    public SaldoModel() {
    }

    public SaldoModel(Double saldo) {
        this.saldo = saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}
