package Estacionamiento;

import java.time.LocalTime;
import java.util.Scanner;

public class Vehiculo {

    // Atributos
    protected String patente;
    protected int valorHora;
    protected LocalTime horaDeEntrada;
    protected String tipo;

    // Metodo constructor
    public Vehiculo(String patente, String tipo, LocalTime horaDeEntrada){
        // mandar al main el scanner
        this.patente = patente;
        this.tipo = tipo;
        this.horaDeEntrada = horaDeEntrada;
    }

    // Getter - Setter
    public void setPatente(String patente){
        this.patente = patente;
    }

    String getPatente(){
        return this.patente;
    }

    LocalTime getHoradeEntrada(){
        return this.horaDeEntrada;
    }

    void setHoraEntrada(LocalTime horadeEntrada){
        this.horaDeEntrada = horadeEntrada;
    }
}
