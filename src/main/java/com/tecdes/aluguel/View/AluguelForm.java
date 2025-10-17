package com.tecdes.aluguel.View;

import java.awt.LayoutManager;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.tecdes.aluguel.Controller.AluguelController;
import com.tecdes.aluguel.Model.Aluguel;
import com.tecdes.aluguel.Model.AluguelApartamento;
import com.tecdes.aluguel.Model.AluguelCasa;
import com.tecdes.aluguel.Model.AluguelComercial;

public class AluguelForm extends JFrame {
    private JTextField txtValor;
    private JComboBox<String> cmbImovel;
    private JTextArea txtResultado;
    private AluguelController controller;

    public AluguelForm() {
        setSize(420, 520);
        setTitle("Gestor de Alugueis");
        setDefaultCloseOperation(3);
        setLayout((LayoutManager) null);
        setResizable(false);
        
        controller = new AluguelController();
        initComponents();
    }

    private void initComponents() {

        // ENTRADAS
        JLabel lblValor = new JLabel("Valor (R$):");
        lblValor.setBounds(40, 30, 100, 25);
        add(lblValor);

        JTextField txtValor = new JTextField();
        txtValor.setBounds(150, 30, 200, 25);
        add(txtValor);

        JLabel lblMeses = new JLabel("Meses:");
        lblMeses.setBounds(40, 70, 100, 25);
        add(lblMeses);

        JTextField txtMeses = new JTextField();
        txtMeses.setBounds(150, 70, 200, 25);
        add(txtMeses);

        JLabel lblImovel = new JLabel("Aluguel Desejado:");
        lblImovel.setBounds(40, 120, 150, 25);
        add(lblImovel);

        cmbImovel = new JComboBox<>(new String[] { "Casa", "Apartamento", "Comercial" });
        cmbImovel.setBounds(190, 120, 160, 25);
        add(cmbImovel);

        // BOTOES
        JButton btnProcessar = new JButton("Processar Aluguel");
        btnProcessar.setBounds(120, 200, 180, 35);
        add(btnProcessar);

        JButton btnSalvarHistorico = new JButton("Salvar Histórico");
        btnSalvarHistorico.setBounds(120, 240, 180, 35);
        add(btnSalvarHistorico);

        JButton btnRecarregarHistorico = new JButton("Recarregar Histórico");
        btnRecarregarHistorico.setBounds(120, 280, 180, 35);
        add(btnRecarregarHistorico);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setLineWrap(true);
        txtResultado.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(txtResultado);
        scroll.setBounds(40, 350, 320, 100);
        add(scroll);

        // EVENTOS
        btnProcessar.addActionListener(e -> processar());
        
        btnSalvarHistorico.addActionListener(e -> btnSalvarHistoricoEmArquivo());
    }

    private void processar() {
        try {
            double valor = Double.parseDouble(txtValor.getText());
            String metodo = cmbImovel.getSelectedItem().toString();

            System.out.println(metodo);
            System.out.println(cmbImovel.getSelectedItem());

            Aluguel aluguel = obterMetodo(metodo);

            String resultado = controller.processarAluguel(aluguel);
            txtResultado.append(resultado + "\n");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido...");
        }
    }

    private Aluguel obterMetodo(String metodo){
    
        if(metodo.equals("Casa")){
            return new AluguelCasa();
        }
        if(metodo.equals("Apartamento")){
            return new AluguelApartamento();
        }
        return new AluguelComercial();
    }

    private void btnSalvarHistoricoEmArquivo() {
        List<String> alugueis = controller.listarAlugueis();

        if (alugueis.isEmpty()) { // verifica se pagamentos está vazio
            JOptionPane.showMessageDialog(null, "Não há pagamentos no histórico. ");
            return;
        }

        try (FileWriter writer = new FileWriter("alugueis.txt")) {
            for (String registro : alugueis) {
                writer.write(registro);
            }
            JOptionPane.showMessageDialog(null, "Gravação do Arquivo com Sucesso!! ");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de salvar o arquivo: " + e.getMessage());
        }

    }
}
//     private void btnRecarregarHistorico() {
       
// }
