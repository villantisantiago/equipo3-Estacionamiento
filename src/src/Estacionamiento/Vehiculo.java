package Estacionamiento;

public class Vehiculo {

    // Atributos
    String tipo;
    String marca;
    String modelo;
    private String patente;

    // Metodo constructor
    Vehiculo(){
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
    }

    // Getter - Setter
    void setPatente(String patente){
        this.patente = patente;
    }
}

class Auto extends Vehiculo {
    // Vehiculo obj = new Vehiculo();
}

class Camioneta extends Vehiculo{
    //
}
