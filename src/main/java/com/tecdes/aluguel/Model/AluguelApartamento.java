package com.tecdes.aluguel.Model;

public class AluguelApartamento implements Aluguel {

    double ValorMensal;
    int Meses;

    @Override
    public String calcular() {
        return "Contrato de Aluguel de Apartamento: " + ValorMensal*Meses;
    }

    

}
