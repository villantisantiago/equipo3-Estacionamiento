package Estacionamiento;

import java.time.LocalTime;
import java.util.Scanner;

public class Vehiculo {

    // Atributos
    protected String patente;
    protected int valorHora;
    protected LocalTime horadeEntrada;
    protected String tipo;

    // Metodo constructor
    public Vehiculo(String patente, String tipo){
        // mandar al main el scanner
        this.patente = patente;
        this.tipo = tipo;
    }

    // Getter - Setter
    public void setPatente(String patente){
        this.patente = patente;
    }

    String getPatente(){
        return this.patente;
    }

    String getHoradeEntrada(){
        return this.patente;
    }
}
