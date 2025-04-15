/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import data.Persistencia;
import domain.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AltaAnimalView extends JFrame {
    private JTextField nombreField = new JTextField();
    private JTextField edadField = new JTextField();
    private JTextField pesoField = new JTextField();
    private JComboBox<Especie> especieBox = new JComboBox<>(Controlador.getEspecies().toArray(new Especie[0]));
    private JComboBox<Sector> sectorBox = new JComboBox<>(Controlador.getSectores().toArray(new Sector[0]));
    private JTextField valorFijoField = new JTextField(); // solo si herbívoro
    private JTextField paisField = new JTextField();
    private JButton guardarBtn = new JButton("Guardar");

    public AltaAnimalView() {
        setTitle("Agregar Animal");
        setLayout(new GridLayout(8, 2));
        add(new JLabel("Nombre:")); add(nombreField);
        add(new JLabel("Edad:")); add(edadField);
        add(new JLabel("Peso:")); add(pesoField);
        add(new JLabel("Especie:")); add(especieBox);
        add(new JLabel("Sector:")); add(sectorBox);
        add(new JLabel("Valor fijo (solo herbívoro):")); add(valorFijoField);
        add(new JLabel("País de origen:")); add(paisField);
        add(new JLabel("")); add(guardarBtn);

        guardarBtn.addActionListener(e -> {
            try {
                Especie especie = (Especie) especieBox.getSelectedItem();
                Sector sector = (Sector) sectorBox.getSelectedItem();
                Mamifero nuevo;
                String nombre = nombreField.getText();
                int edad = Integer.parseInt(edadField.getText());
                double peso = Double.parseDouble(pesoField.getText());
                Pais pais = new Pais(paisField.getText());

                if (especie.getTipoAlimentacion().esHerbivoro()) {
                    double valorFijo = Double.parseDouble(valorFijoField.getText());
                    nuevo = new Herbivoro(edad, peso, especie, sector, valorFijo, pais);
                } else {
                    nuevo = new Carnivoro(edad, peso, especie, sector, pais);
                }

                Persistencia.agregarAnimal(nuevo);
                JOptionPane.showMessageDialog(this, "Animal agregado");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
