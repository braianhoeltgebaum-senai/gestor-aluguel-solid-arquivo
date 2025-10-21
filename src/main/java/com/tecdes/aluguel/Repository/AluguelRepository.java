package com.tecdes.aluguel.Repository;

import java.util.ArrayList;
import java.util.List;

public class AluguelRepository {
    private List<String> registros = new ArrayList<>();

    public void salvar(String registro){
        registros.add(registro);
        System.out.println("Registro Salvo com Sucesso: " + registros);

    }

    public List<String> Listar(){
        return new ArrayList<>(registros);
    } 
}