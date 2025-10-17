package com.tecdes.aluguel.Model;

public class AluguelCasa implements Aluguel {

    double ValorMensal;
    int Meses;

    @Override
    public String calcular() {
        return "Contrato de Aluguel de Casa: "+ ValorMensal*Meses;
    }

}
