package org.example;

class Carteira {
    private double saldo;

    public Carteira(double saldoInicial) {
        saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void adicionarSaldo(double valor) {
        saldo += valor;
    }

    public void removerSaldo(double valor) {
        saldo -= valor;
    }
}