/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipalView extends JFrame {

    private JButton listarBtn = new JButton("Listar Animales");
    private JButton agregarBtn = new JButton("Agregar Animal");

    public MenuPrincipalView() {
        setTitle("Menú Principal - Zoológico");
        setLayout(new GridLayout(2, 1, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        add(listarBtn);
        add(agregarBtn);

        listarBtn.addActionListener(e -> new ListarAnimalesView().setVisible(true));
        agregarBtn.addActionListener(e -> new AltaAnimalView().setVisible(true));

        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuPrincipalView();
    }
}

