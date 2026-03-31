package Estacionamiento;


public class Vehiculo {

    // Atributos
    String tipo;
    String marca;
    String modelo;
    private String patente;


    // Metodo constructor
    Vehiculo(String tipo, String marca, String modelo, String patente){
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
