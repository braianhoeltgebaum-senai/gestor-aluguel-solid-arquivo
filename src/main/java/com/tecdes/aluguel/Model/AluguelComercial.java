package com.tecdes.aluguel.Model;

public class AluguelComercial implements Aluguel{

    double ValorMensal;
    int Meses;

    @Override
    public String calcular() {
        return "Contrato de Aluguel Comercial: "+ ValorMensal*Meses;
    }

}
