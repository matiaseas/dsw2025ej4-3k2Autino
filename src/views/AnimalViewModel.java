
package views;

import domain.Carnivoro;
import domain.Herbivoro;
import domain.Mamifero;


public class AnimalViewModel{

    ///variables de la clase
    private String especie;
    private int edad;
    private String sector;
    private double peso;
    private double valorFijo;
    private double porcentaje;
    

    public AnimalViewModel(Mamifero animal) {
        if(animal == null) return;
        especie = animal.getEspecie().getNombre();
        edad = animal.getEdad();
        sector = animal.getSector().toString();
        peso = animal.getPeso();
        valorFijo = animal instanceof Herbivoro ? ((Herbivoro) animal).getValorFijo() : 0;
        porcentaje = animal instanceof Carnivoro ? animal.getEspecie().getPorcentajePesoCarnivoro() : 0;
    }

    public String getEspecie() {
        return especie;
    }

    public int getEdad() {
        return edad;
    }

    public String getSector() {
        return sector;
    }

    public double getPeso() {
        return peso;
    }

    public double getValorFijo() {
        return valorFijo;
    }
    
    public double getPorcentaje(){
        return porcentaje;
    }
}
