package com.tecdes.aluguel.Controller;

import java.util.List;

import com.tecdes.aluguel.Model.Aluguel;
import com.tecdes.aluguel.Repository.AluguelRepository;

public class AluguelController {

    private AluguelRepository repository; //Injeção de dependência na classe (Controller depende de repository)

    public AluguelController(){
        repository = new AluguelRepository();

    }

    public String processarAluguel(Aluguel aluguel) {
        
    }

    public List<String> listarAlugueis() {
        
    }
}
