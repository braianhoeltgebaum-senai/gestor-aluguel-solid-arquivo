package com.tecdes.aluguel.Controller;

import java.util.List;

import com.tecdes.aluguel.Model.Aluguel;
import com.tecdes.aluguel.Repository.AluguelRepository;

public class AluguelController {

    private AluguelRepository repository; //Injeção de dependência na classe (Controller depende de repository)

    public AluguelController(){
        repository = new AluguelRepository();

    }

    public String processarAluguel(Aluguel aluguel){
        String resultado = aluguel.calcular();
        repository.salvar(resultado);
        System.out.println("Pagamento Registrado: " + resultado);
        return resultado;
    }

    public List<String> listarAlugueis(){
        List<String> lista = repository.Listar();
        System.out.println("Lista de Alugueis: " + lista);
        return lista;
    }
}

    

    

