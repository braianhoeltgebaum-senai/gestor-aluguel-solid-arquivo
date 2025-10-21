package com.tecdes.aluguel.Model;

public class AluguelComercial implements Aluguel{

    private double ValorMensal;
    private int Meses;

    public AluguelComercial(double valorMensal, int meses) {
        ValorMensal = valorMensal;
        Meses = meses;
    }

    @Override
    public String calcular() {
        double resultado = ValorMensal*Meses;
        return String.format("Aluguel de Apartamento no valor de R$: %.2f", resultado);
    }

}
