package com.tecdes.aluguel;

import javax.swing.SwingUtilities;

import com.tecdes.aluguel.View.AluguelForm;

public class AppAluguel {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AluguelForm().setVisible(true));
    }
}