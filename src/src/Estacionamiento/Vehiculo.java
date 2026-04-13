package Estacionamiento;

import java.time.LocalTime;
import java.util.Scanner;

public class Vehiculo {

    // Atributos
    protected String patente;
    protected int valorHora;
    protected LocalTime horadeEntrada;

    // Metodo constructor
    public Vehiculo(String patente, LocalTime hora, int preciohora){
        // mandar al main el scanner
        this.patente = patente;
        horadeEntrada = hora;
        valorHora = preciohora;
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

class Auto extends Vehiculo {
    // Vehiculo obj = new Vehiculo();
    public Auto (String patente, String hora){
        super(patente ,hora,2500);
    }

}

class Camioneta extends Vehiculo{
    //
    public Camioneta (String patente, String hora){
        super(patente,hora,3500);;
    }

}
