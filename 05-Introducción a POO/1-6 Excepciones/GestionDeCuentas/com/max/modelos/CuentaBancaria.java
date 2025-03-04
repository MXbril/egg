package com.max.modelos;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void retirar(double cantidad) throws SaldoInsuficienteException, CantidadNegativaException {
        if (cantidad < 0) {
            throw new CantidadNegativaException("La cantidad ha retirar no puede ser negativa.");
        }
        
        if (cantidad > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar el retiro " +cantidad+ " unidades.");
        }
        saldo -= cantidad;
        System.out.println("Retiro de " +cantidad+ " unidades realizado con éxito. Saldo restante: " +saldo);
    }
}
